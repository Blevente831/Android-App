const { Firestore: FirestoreDB } = require('@google-cloud/firestore');
const firebase = require('firebase-admin');
const path = require('path');
const fs = require('fs');

// Singleton for Firestore service
class FirestoreService {
  constructor() {
    this.db = null;
  }
  
  /**
   * Initialize Firestore client
   */
  async initialize() {
    try {
    
      let credentialsPath;
      
      // First check environment variable
      if (process.env.GOOGLE_APPLICATION_CREDENTIALS) {
        credentialsPath = process.env.GOOGLE_APPLICATION_CREDENTIALS;
        console.log(`Using credentials from environment variable: ${credentialsPath}`);
      } else {
       
        const possiblePaths = [
          
          path.resolve(__dirname, '../android-app-71377-4e1de32828d9.json'),    
          // Container paths for Cloud Run
          '/app/android-app-71377-4e1de32828d9.json',
          '/app/credentials/android-app-71377-4e1de32828d9.json',
          
          // Cloud Run workspace paths (added for cloud compatibility)
          '/workspace/android-app-71377-4e1de32828d9.json',
        ];
        
     
      }
      
      
      if (credentialsPath) {
        try {
          firebase.initializeApp({
            credential: firebase.credential.cert(credentialsPath)
          });
          this.db = firebase.firestore();
          console.log('Firestore initialized successfully with firebase-admin');
          return true;
        } catch (firebaseError) {
          console.error('Error initializing with firebase-admin:', firebaseError);
          console.log('Falling back to direct Firestore initialization');
        }
      }
      
      this.db = new FirestoreDB({
        keyFilename: credentialsPath 
      });
      
      console.log('Firestore initialized successfully with direct initialization');
      return true;
    } catch (error) {
      console.error('Error initializing Firestore:', error);
      
      if (process.env.USE_IN_MEMORY === 'true') {
        console.log('Falling back to in-memory database');
        return false;
      }
      
      throw error; 
    }
  }
  
  /**
   * Get a reference to a collection
   * @param {string} collectionName - The name of the collection
   * @returns {Object} - Collection reference
   */
  collection(collectionName) {
    if (!this.db) {
      throw new Error('Database not initialized');
    }
    return this.db.collection(collectionName);
  }
  
  /**
   * Create a new batch write operation
   * @returns {Object} - Batch operation
   */
  batch() {
    if (!this.db) {
      throw new Error('Database not initialized');
    }
    return this.db.batch();
  }
  
  /**
   * Run a transaction
   * @param {Function} updateFunction - Function to execute in transaction
   * @returns {Promise<*>} - Result of the transaction
   */
  async runTransaction(updateFunction) {
    if (!this.db) {
      throw new Error('Database not initialized');
    }
    return await this.db.runTransaction(updateFunction);
  }
}

// Create singleton instance
const Firestore = new FirestoreService();

// Export initialize function and singleton
module.exports = {
  Firestore,
  initializeFirestore: async () => await Firestore.initialize()
};
