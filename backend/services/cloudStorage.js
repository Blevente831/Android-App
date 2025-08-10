const { Storage } = require('@google-cloud/storage');
const fs = require('fs');
const path = require('path');

// Singleton for Cloud Storage service
class CloudStorageService {
  constructor() {
    this.storage = null;
    this.bucket = null;
    this.bucketName = 'smart-home-events';
    this.events = []; 
  }

  async initialize() {
    try {
      
      const credentialsPaths = [
        path.resolve(__dirname, '../android-app-71377-4e1de32828d9.json'),
       
        
        // Container paths for Cloud Run
        '/app/android-app-71377-4e1de32828d9.json',
        '/app/credentials/android-app-71377-4e1de32828d9.json',
        
        // Cloud Run workspace paths 
        '/workspace/android-app-71377-4e1de32828d9.json'
      ];
      
      let initialized = false;
      let lastError = null;
      let credentialsPath = '';
      
      
      
      // If none of the credential files worked, throw the last error
      if (!initialized) {
        throw lastError || new Error('All Cloud Storage credential files failed');
      }
      
      // Setup bucket with retry logic
      try {
        // Add timeout for the initial bucket check operation
        const timeoutPromise = new Promise((_, reject) => 
          setTimeout(() => reject(new Error('Cloud Storage getBuckets operation timed out')), 15000)
        );
        
        let bucketInitSuccess = false;
        let initAttempt = 0;
        const MAX_INIT_ATTEMPTS = 3;
        
        while (!bucketInitSuccess && initAttempt < MAX_INIT_ATTEMPTS) {
          try {
            initAttempt++;
            console.log(`Checking if bucket '${this.bucketName}' exists... (attempt ${initAttempt}/${MAX_INIT_ATTEMPTS})`);
            
            // Try to get buckets with timeout
            const getBucketsPromise = this.storage.getBuckets();
            const [buckets] = await Promise.race([getBucketsPromise, timeoutPromise]);
            
            const bucketExists = buckets.some(bucket => bucket.name === this.bucketName);
            
            if (!bucketExists) {
              console.log(`Creating bucket: ${this.bucketName}`);
              await this.storage.createBucket(this.bucketName);
            }
            
            this.bucket = this.storage.bucket(this.bucketName);
            console.log('Google Cloud Storage initialized successfully!');
            bucketInitSuccess = true;
          } catch (retryError) {
            console.error(`Bucket initialization attempt ${initAttempt} failed:`, retryError.message);
            
            // If we hit max retries, throw to the outer catch
            if (initAttempt >= MAX_INIT_ATTEMPTS) {
              throw retryError;
            }
            
            // Add delay before retry
            const delay = 1000 * Math.pow(2, initAttempt - 1); // 1s, 2s, 4s
            console.log(`Retrying bucket initialization in ${delay}ms...`);
            await new Promise(resolve => setTimeout(resolve, delay));
          }
        }
      } catch (bucketError) {
        console.error('Error with bucket operations:', bucketError);
        console.log('Using local event storage as fallback');
        
        // Use in-memory fallback methods for bucket operations
        this.bucket = {
          file: (filename) => {
            return {
              save: async (content, options) => {
                // Store in memory
                this.events.push({
                  filename,
                  content,
                  metadata: options.metadata,
                  created: new Date()
                });
                console.log(`Stored event in memory: ${filename}`);
                return true;
              },
              download: async () => {
                // Find file content
                const file = this.events.find(e => e.filename === filename);
                return [file ? file.content : '{}'];
              }
            };
          },
          getFiles: async (options) => {
            const prefix = options.prefix || '';
            
            // Filter files by prefix
            const files = this.events
              .filter(e => e.filename.startsWith(prefix))
              .map(e => ({
                name: e.filename,
                download: async () => [e.content]
              }));
            
            return [files.slice(0, options.maxResults || 100)];
          }
        };
      }
      
      return true;
    } catch (error) {
      console.error('Error initializing Cloud Storage:', error);
      // Continue with app but without Cloud Storage functionality
      console.log('App will run with in-memory event storage as fallback');
      
      // Initialize in-memory fallback
      this.events = [];
      this.bucket = {
        file: (filename) => {
          return {
            save: async (content, options) => {
              this.events.push({
                filename, 
                content,
                metadata: options.metadata,
                created: new Date()
              });
              return true;
            },
            download: async () => {
              const file = this.events.find(e => e.filename === filename);
              return [file ? file.content : '{}'];
            }
          };
        },
        getFiles: async (options) => {
          const prefix = options.prefix || '';
          const files = this.events
            .filter(e => e.filename.startsWith(prefix))
            .map(e => ({
              name: e.filename,
              download: async () => [e.content]
            }));
          return [files.slice(0, options.maxResults || 100)];
        }
      };
    }
  }
  
  /**
   * Store an event in Cloud Storage
   * @param {Object} eventData - The event data to store
   * @returns {Promise<Object>} - The stored event
   */
  async storeEvent(eventData) {
    if (!this.bucket) {
      console.warn('Cloud Storage not initialized, skipping event storage');
      return eventData;
    }
    
    try {
      // Generate a unique filename for the event
      const timestamp = new Date().toISOString().replace(/[:.]/g, '-');
      const eventType = eventData.type || 'unknown';
      const userId = eventData.userId || 'anonymous';
      const deviceId = eventData.deviceId || 'no-device';
      
      const filename = `events/${userId}/${eventType}_${deviceId}_${timestamp}.json`;
      
      // Create a file in the bucket
      const file = this.bucket.file(filename);
      
      // Upload the event data as JSON
      await file.save(JSON.stringify(eventData, null, 2), {
        contentType: 'application/json',
        metadata: {
          eventType,
          userId,
          deviceId,
          timestamp: new Date().toISOString()
        }
      });
      
      console.log(`Event stored in Cloud Storage: ${filename}`);
      return eventData;
    } catch (error) {
      console.error('Error storing event in Cloud Storage:', error);
      // Return the event data anyway, even if storage failed
      return eventData;
    }
  }
  
  /**
   * Retrieve events for a specific device
   * @param {string} deviceId - The device ID to get events for
   * @param {number} limit - Maximum number of events to retrieve
   * @returns {Promise<Array>} - Array of event objects
   */
  async getDeviceEvents(deviceId, limit = 50) {
    if (!this.bucket) {
      console.warn('Cloud Storage not initialized, cannot retrieve events');
      return [];
    }
    
    
    try {
      // List files with retry
      const listFilesOperation = async () => {
        // Add timeout for the storage operation
        const timeout = 8000; // 8 seconds
        const listFilesPromise = this.bucket.getFiles({
          prefix: `events/`,
          autoPaginate: false,
          maxResults: 100 // Get a larger set to filter from
        });
        
        const timeoutPromise = new Promise((_, reject) => 
          setTimeout(() => reject(new Error('Cloud Storage listing operation timed out')), timeout)
        );
        
        return await Promise.race([listFilesPromise, timeoutPromise]);
      };
      
      // Execute file listing with retry
      const [files] = await retryOperation(listFilesOperation, MAX_LIST_RETRIES, 'list files');
      
      // Filter files for this device
      const deviceFiles = files.filter(file => {
        return file.name.includes(`_${deviceId}_`);
      });
      
      // Sort by most recent first (based on filename timestamp)
      deviceFiles.sort((a, b) => b.name.localeCompare(a.name));
      
      // Limit the number of files
      const limitedFiles = deviceFiles.slice(0, limit);
      
      // Download and parse each file with individual retries
      const events = [];
      for (const file of limitedFiles) {
        try {
          const downloadOperation = async () => {
            const downloadTimeout = 8000; // Increased from 5 to 8 seconds per file
            
            // Create a download promise with extra options
            const downloadPromise = file.download({
              validation: false // Skip MD5 validation to speed up downloads
            });
            
            const timeoutPromise = new Promise((_, reject) => 
              setTimeout(() => reject(new Error(`Download timed out for ${file.name}`)), downloadTimeout)
            );
            
            try {
              return await Promise.race([downloadPromise, timeoutPromise]);
            } catch (error) {
              console.warn(`Error during first download attempt: ${error.message}`);
              
              // Try one more time with a simpler approach
              return await file.download({
                validation: false,
                timeout: 10000 // Direct timeout option
              });
            }
          };
          
          // Execute download with retry
          const [content] = await retryOperation(
            downloadOperation, 
            MAX_DOWNLOAD_RETRIES, 
            `download ${file.name}`
          );
          
          events.push(JSON.parse(content.toString()));
        } catch (downloadError) {
          console.warn(`Error downloading file ${file.name}:`, downloadError.message);
          // Continue with other files
        }
      }
      
      return events;
    } catch (error) {
      console.error('Error retrieving device events from Cloud Storage:', error);
      return [];
    }
  }
  
  /**
   * Retrieve usage data for user behavior analysis
   * @param {string} userId - The user ID to get data for
   * @param {number} days - Number of days of data to retrieve
   * @returns {Promise<Array>} - Array of events for analysis
   */
  async getUserBehaviorData(userId, days = 30) {
    if (!this.bucket) {
      console.warn('Cloud Storage not initialized, cannot retrieve behavior data');
      return [];
    }
    
    try {
      // Calculate cutoff date
      const cutoffDate = new Date();
      cutoffDate.setDate(cutoffDate.getDate() - days);
      
      // List files in the events directory for this user with retry
      let files = [];
      try {
        // Add timeout for the storage operation to prevent hanging
        const timeout = 5000; // 5 seconds
        const listFilesPromise = this.bucket.getFiles({
          prefix: `events/${userId}/`,
          autoPaginate: false,
          maxResults: 500 // Get a larger set to filter from
        });
        
        // Create a timeout promise
        const timeoutPromise = new Promise((_, reject) => 
          setTimeout(() => reject(new Error('Cloud Storage operation timed out')), timeout)
        );
        
        // Race between actual operation and timeout
        const result = await Promise.race([listFilesPromise, timeoutPromise]);
        files = result[0] || [];
      } catch (listError) {
        console.error('Error listing files from Cloud Storage:', listError);
        return []; // Return empty array instead of letting the error propagate
      }
      
      // Download and parse each file with individual try/catch
      const events = [];
      for (const file of files) {
        try {
          // Add timeout for each file download
          const downloadTimeout = 20000; // Increased from 3 to 8 seconds per file
          
          // Create a download promise with extra options
          const downloadPromise = file.download({
            validation: false // Skip MD5 validation to speed up downloads
          });
          
          const timeoutPromise = new Promise((_, reject) => 
            setTimeout(() => reject(new Error(`Download timed out for ${file.name}`)), downloadTimeout)
          );
          
          let content;
          try {
            [content] = await Promise.race([downloadPromise, timeoutPromise]);
          } catch (error) {
            console.warn(`Error during first download attempt: ${error.message}`);
            
            // Try one more time with a simpler approach
            [content] = await file.download({
              validation: false,
              timeout: 10000 // Direct timeout option
            });
          }
          events.push(JSON.parse(content.toString()));
        } catch (downloadError) {
          console.warn(`Error downloading file ${file.name}:`, downloadError.message);
          // Continue with other files
        }
      }
      
      // Filter events by date
      const filteredEvents = events.filter(event => {
        try {
          const eventDate = new Date(event.timestamp);
          return eventDate >= cutoffDate;
        } catch (parseError) {
          console.warn('Error parsing event date:', parseError);
          return false;
        }
      });
      
      return filteredEvents;
    } catch (error) {
      console.error('Error retrieving user behavior data from Cloud Storage:', error);
      return [];
    }
  }
}

const CloudStorage = new CloudStorageService();

module.exports = {
  CloudStorage,
  initializeCloudStorage: async () => await CloudStorage.initialize()
};
