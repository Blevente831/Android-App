const { VertexAI: VertexAIClient } = require('@google-cloud/vertexai');
const path = require('path');
const { CloudStorage } = require('./cloudStorage');

// Singleton for Vertex AI service
class VertexAIService {
  constructor() {
    this.vertexai = null;
    this.model = null;
    this.projectId = 'android-app-71377';
    this.location = 'us-central1';
    
    this.modelOptions = [
      'gemini-2.0-flash-001'// Latest Gemini 2.0 model 
    ];
    
    this.modelName = this.modelOptions[0]; // Start with the first model

  }
  /**
   * Initialize Vertex AI client
   */
  async initialize() {
    try {
     
      const credentialsPaths = [
        // Local development paths
        path.resolve(__dirname, '../android-app-71377-4e1de32828d9.json'),
        // Container paths for Cloud Run
        '/app/android-app-71377-4e1de32828d9.json',
        '/app/credentials/android-app-71377-4e1de32828d9.json',
        
        // Cloud Run workspace paths 
        '/workspace/android-app-71377-4e1de32828d9.json'
      ];
      
     
      
      console.log(`Vertex AI initialized successfully with model: ${this.modelName}`);
      return true;
    } catch (error) {
      console.error('Error initializing Vertex AI:', error);
      
      // More detailed error logging for troubleshooting
      if (error.message) console.error('Error message:', error.message);
      if (error.code) console.error('Error code:', error.code);
      if (error.details) console.error('Error details:', error.details);
      if (error.stack) console.error('Error stack:', error.stack);
      
      // Continue with app but without AI functionality
      console.log('App will run without AI functionality but other features will work');
      
      // Still return to allow app to function without AI
      return false;
    }
  }
  
  /**
   * Create a mock AI response for development
   * @param {string} category - Device category
   * @returns {Object} - Mock insights
   */
  createMockResponse(category) {
    const responses = {
      light: {
        timePatterns: [
          "Most frequent usage in evenings (6-10pm)",
          "Often turned on in early morning (6-8am)",
          "Rarely used during mid-day (10am-3pm)"
        ],
        dayPatterns: [
          "Higher usage on weekends",
          "Consistent usage pattern Monday through Friday"
        ],
        preferences: {
          brightness: "Typically set between 60-80%",
          color: "Warm white preferred in evenings, cooler tones in mornings"
        },
        automationSuggestions: [
          "Schedule lights to turn on at sunset",
          "Turn off all lights at midnight",
          "Dim lights in the evening after 9pm",
          "Turn on hallway lights at low brightness during night hours"
        ],
        energySavingTips: [
          "Reduce brightness by 20% to save energy without noticeable difference",
          "Turn off lights automatically when no motion detected for 10 minutes",
          "Use scene settings instead of turning on multiple lights individually"
        ]
      },
      thermostat: {
        timePatterns: [
          "Temperature raised in mornings (6-8am)",
          "Temperature lowered during work hours (9am-5pm)",
          "Temperature raised again in evenings (5-10pm)"
        ],
        dayPatterns: [
          "More consistent temperatures maintained on weekends",
          "More temperature adjustments on Mondays and Fridays"
        ],
        preferences: {
          temperature: "Preferred range 70-72°F when home, 65-68°F when away or sleeping",
          mode: "Heat mode used most frequently"
        },
        automationSuggestions: [
          "Lower temperature automatically when everyone leaves home",
          "Raise temperature 30 minutes before wake-up time",
          "Set energy-saving temperature when sleeping",
          "Switch to eco mode during typical work hours"
        ],
        energySavingTips: [
          "Reducing temperature by 1-2 degrees can save 5-10% on energy costs",
          "Use smart home presence detection to automatically adjust temperature",
          "Schedule regular HVAC maintenance to improve efficiency"
        ]
      },
      security: {
        timePatterns: [
          "System armed at night (10pm-6am)",
          "System disarmed during daytime hours",
          "Most motion detections in evenings (6-9pm)"
        ],
        dayPatterns: [
          "More consistent arming pattern on weekdays",
          "More frequent disarming/arming on weekends"
        ],
        preferences: {
          sensitivity: "Medium sensitivity preferred",
          alertType: "Mobile notifications preferred over sounds"
        },
        automationSuggestions: [
          "Arm system automatically at sunset or 10pm",
          "Turn on lights when motion detected during night hours",
          "Record video when unexpected motion detected during normally quiet periods",
          "Send detailed alerts when pattern deviates from normal household activity"
        ],
        energySavingTips: [
          "Reduce camera resolution when no one is home to save bandwidth",
          "Schedule system checks during off-peak hours",
          "Use geofencing to reduce false alarms and unnecessary recordings"
        ]
      },
      entertainment: {
        timePatterns: [
          "Most active use in evenings (7-11pm)",
          "Occasional usage in mornings on weekends",
          "Peak usage Friday and Saturday nights"
        ],
        dayPatterns: [
          "Higher usage on weekends",
          "Lower usage on Mondays and Tuesdays"
        ],
        preferences: {
          volume: "Typically set between 30-40%",
          input: "Streaming services used most frequently"
        },
        automationSuggestions: [
          "Dim lights automatically when movie content is playing",
          "Create a 'Movie Night' scene that adjusts lighting and sound",
          "Set volume limits during late night hours",
          "Pause content when doorbell rings or during phone calls"
        ],
        energySavingTips: [
          "Set auto-shutdown after 2 hours of inactivity",
          "Optimize display brightness based on room lighting",
          "Schedule system updates during non-peak usage times"
        ]
      },
      appliance: {
        timePatterns: [
          "Used most frequently in mornings (7-9am) and evenings (6-8pm)",
          "Rarely used late at night (11pm-5am)",
          "Peak usage around meal times"
        ],
        dayPatterns: [
          "More usage on weekends",
          "Consistent pattern on weekdays with slight increase on Fridays"
        ],
        preferences: {
          mode: "Eco mode frequently selected",
          timer: "Average run time of 45 minutes"
        },
        automationSuggestions: [
          "Schedule operations during off-peak energy hours",
          "Start coffee maker 10 minutes before typical wake-up time",
          "Send notification when cycle completes",
          "Run dishwasher at night when electricity rates are lower"
        ],
        energySavingTips: [
          "Use eco modes whenever possible",
          "Run appliances only when fully loaded",
          "Schedule regular maintenance to ensure optimal performance",
          "Group appliance usage to reduce energy consumption spikes"
        ]
      },
      speaker: {
        timePatterns: [
          "Most active use in evenings (6-10pm)",
          "Morning usage for news and music (7-9am)",
          "Weekend usage extends into later hours"
        ],
        dayPatterns: [
          "Higher usage on weekends for entertainment",
          "Consistent weekday usage for podcasts and news",
          "Friday and Saturday evening peaks for music"
        ],
        preferences: {
          volume: "Typically set between 25-35%",
          content: "Music streaming most popular, followed by podcasts"
        },
        automationSuggestions: [
          "Create wake-up routine with gradual volume increase",
          "Set quiet hours with automatic volume limits",
          "Link with lighting for ambient music scenes",
          "Schedule news briefings for morning routine"
        ],
        energySavingTips: [
          "Enable sleep mode to reduce standby power",
          "Lower volume settings save battery on portable speakers",
          "Use voice activation sparingly to preserve power"
        ]
      },
      unknown: {
        timePatterns: [
          "Varied usage throughout the day",
          "Some activity in evenings (6-10pm)"
        ],
        dayPatterns: [
          "No clear pattern detected yet",
          "Slightly more activity on weekends"
        ],
        preferences: {
          settings: "Not enough data to determine preferences"
        },
        automationSuggestions: [
          "Create a regular schedule based on typical usage times",
          "Set up basic automation rules as patterns develop",
          "Try different settings to determine preferences"
        ],
        energySavingTips: [
          "Turn off when not in use",
          "Use timers to prevent unnecessary operation",
          "Explore energy-efficient settings"
        ]
      }
    };
    
    return responses[category] || responses.unknown;
  }
  
  /**
   * Process device state to learn user behavior patterns
   * @param {string} userId - User ID
   * @param {Object} deviceState - Current device state
   * @returns {Promise<Object>} - Processed insights
   */
  async processDeviceState(userId, deviceState) {
    // If Vertex AI is not initialized, just log the event
    if (!this.model) {
      console.warn('Vertex AI not initialized, storing event without processing');
      
      // Still store the event for future processing
      await CloudStorage.storeEvent({
        type: 'device_state',
        userId,
        deviceId: deviceState.deviceId,
        state: deviceState,
        timestamp: new Date().toISOString()
      });
      
      return { processed: false };
    }
    
    try {
      // Store the event for future reference
      await CloudStorage.storeEvent({
        type: 'device_state',
        userId,
        deviceId: deviceState.deviceId,
        state: deviceState,
        timestamp: new Date().toISOString()
      });
      
      // Get recent events for this user
      const userEvents = await CloudStorage.getUserBehaviorData(userId, 30);
      
      // If we don't have enough data yet, just return
      if (userEvents.length < 10) {
        return { processed: true, insights: null, message: 'Not enough data for insights' };
      }
      
      // Filter for events related to this device
      const deviceEvents = userEvents.filter(event => 
        event.deviceId === deviceState.deviceId
      );
      
      // Prepare data for analysis
      const deviceData = deviceEvents.map(event => {
        // Extract time information for pattern detection
        const date = new Date(event.timestamp);
        const hour = date.getHours();
        const minute = date.getMinutes();
        const day = date.getDay(); // 0 = Sunday, 6 = Saturday
        
        // Return structured data
        return {
          timestamp: event.timestamp,
          hour,
          minute,
          day,
          isWeekend: day === 0 || day === 6,
          isOn: event.state?.isOn,
          brightness: event.state?.brightness,
          properties: event.state?.properties
        };
      });
      
      // Analyze patterns using Vertex AI
      // Use text-based prompting to extract insights
      const prompt = this.createAnalysisPrompt(deviceState, deviceData);
      
      // Add retry logic for Vertex AI calls
  
      
      // Extract the text response, handling potential differences in response format
      let textResponse;
      try {
        const response = result.response;
        textResponse = response.text();
      } catch (parseError) {
        // Fallback for older format or different models
        try {
          const response = result.response;
          textResponse = response.candidates[0].content.parts[0].text;
        } catch (secondParseError) {
          console.error('Error parsing AI response:', secondParseError);
          // Use a generic message if we can't parse the response
          textResponse = 'Unable to parse AI response. Please check device usage patterns manually.';
        }
      }
      
      // Parse the AI response to get structured insights
      const insights = this.parseAIResponse(textResponse);
      
      return {
        processed: true,
        deviceId: deviceState.deviceId,
        insights,
        analysisTimestamp: new Date().toISOString()
      };
    } catch (error) {
      console.error('Error processing device state with Vertex AI:', error);
      return { 
        processed: false, 
        error: error.message 
      };
    }
  }
  
  /**
   * Create a prompt for the AI model to analyze device usage patterns
   * @param {Object} currentState - Current device state
   * @param {Array} historyData - Historical device data
   * @returns {string} - Formatted prompt for AI
   */
  createAnalysisPrompt(currentState, historyData) {
    // For more advanced analysis, use more historical data points
    const dataPoints = historyData.length > 50 
      ? historyData.slice(-50) // Take last 50 records for more comprehensive analysis
      : historyData;
    
    // Create time-based aggregations for better pattern detection
    const hourlyUsage = Array(24).fill(0);
    const dayOfWeekUsage = Array(7).fill(0);
    const weekdayVsWeekend = [0, 0]; // [weekday, weekend]
    const morningVsEvening = [0, 0]; // [morning (5-11), evening (17-23)]
    const settingsValues = {};
    
    // Extract time-based patterns from historical data
    dataPoints.forEach(point => {
      // Track hourly usage
      if (point.hour !== undefined) {
        hourlyUsage[point.hour]++;
      }
      
      // Track day of week usage
      if (point.day !== undefined) {
        dayOfWeekUsage[point.day]++;
        
        // Track weekday vs weekend
        if (point.day === 0 || point.day === 6) {
          weekdayVsWeekend[1]++; // weekend
        } else {
          weekdayVsWeekend[0]++; // weekday
        }
      }
      
      // Track morning vs evening usage
      if (point.hour !== undefined) {
        if (point.hour >= 5 && point.hour <= 11) {
          morningVsEvening[0]++; // morning
        } else if (point.hour >= 17 && point.hour <= 23) {
          morningVsEvening[1]++; // evening
        }
      }
      
      // Track settings values
      if (point.properties) {
        Object.entries(point.properties).forEach(([key, value]) => {
          if (typeof value === 'number' || typeof value === 'boolean') {
            if (!settingsValues[key]) {
              settingsValues[key] = [];
            }
            settingsValues[key].push(value);
          }
        });
      }
      
      // Add brightness tracking
      if (point.brightness !== undefined) {
        if (!settingsValues.brightness) {
          settingsValues.brightness = [];
        }
        settingsValues.brightness.push(point.brightness);
      }
    });
    
    // Calculate average settings values
    const averageSettings = {};
    Object.entries(settingsValues).forEach(([key, values]) => {
      if (values.every(v => typeof v === 'number')) {
        averageSettings[key] = values.reduce((sum, val) => sum + val, 0) / values.length;
      } else if (values.every(v => typeof v === 'boolean')) {
        // For boolean values, calculate the percentage of true values
        const trueCount = values.filter(v => v === true).length;
        averageSettings[key] = trueCount / values.length;
      }
    });
    
    // Calculate peak usage hours
    const peakHours = hourlyUsage
      .map((count, hour) => ({ hour, count }))
      .sort((a, b) => b.count - a.count)
      .slice(0, 3)
      .map(item => item.hour);
    
    // Create enhanced analytics summary
    const analytics = {
      hourlyUsage,
      dayOfWeekUsage,
      weekdayVsWeekend,
      morningVsEvening,
      peakHours,
      averageSettings
    };
    
    // Include enhanced analytics in the prompt
    const analyticsString = JSON.stringify(analytics, null, 2);
    const dataString = JSON.stringify(dataPoints, null, 2);
    
    // Current date/time for contextual awareness
    const now = new Date();
    const currentHour = now.getHours();
    const currentDay = now.getDay();
    const isWeekend = currentDay === 0 || currentDay === 6;
    const currentMonth = now.getMonth();
    const seasons = ['winter', 'winter', 'spring', 'spring', 'spring', 'summer', 'summer', 'summer', 'fall', 'fall', 'fall', 'winter'];
    const currentSeason = seasons[currentMonth];
    
    return `
      You are an advanced AI assistant specialized in smart home automation and predictive behavioral analysis. 
      You have expertise in pattern recognition, time-series analysis, and contextual understanding of IoT device usage.
      
      Analyze the following smart home device usage data to identify patterns and provide detailed, predictive insights
      about user behavior and preferences. The data represents a ${currentState.category} device.
      
      Current context:
      - Current hour of day: ${currentHour}
      - Current day of week: ${currentDay} (${isWeekend ? 'weekend' : 'weekday'})
      - Current season: ${currentSeason}
      
      Current device state:
      ${JSON.stringify(currentState, null, 2)}
      
      Statistical analysis of historical usage:
      ${analyticsString}
      
      Historical usage data (recent entries):
      ${dataString}
      
      Please perform an advanced analysis of this data and provide the following insights:
      
      1. Time-based usage patterns with specific hour ranges (morning/afternoon/evening/night)
      2. Day-of-week patterns with specific insights for weekdays vs weekends
      3. Detailed settings preferences with optimal ranges for comfort and efficiency
      4. Seasonal adjustment recommendations based on the current season
      5. Predictive automation suggestions that anticipate user needs before they occur
      6. Energy efficiency recommendations with estimated percentage savings
      7. Anomaly detection for unusual usage patterns that might indicate problems
      8. Routine identification that recognizes repeated sequences of behavior
      
      Format your response as valid JSON with the following structure.Return only a valid JSON object, with keys:

      {
        "timePatterns": [...],
        "dayPatterns": [...],
        "preferences": {...},
        "seasonalAdjustments": [...],
        "predictiveAutomations": [...],
        "energySavingTips": [...],
        "anomalies": [...],
        "routines": [...]
      }
      
      Ensure all predictions and suggestions are specific, actionable, and based directly on the observed data.
    `;
  }
  
  /**
   * Parse AI response text into structured data
   * @param {string} responseText - The text response from the AI
   * @returns {Object} - Structured insights
   */
  parseAIResponse(responseText) {
    try {
      // First, check if the entire response is a valid JSON
      try {
        const directJson = JSON.parse(responseText.trim());
        console.log('Successfully parsed direct JSON response');
        return this.normalizeResponseFormat(directJson);
      } catch (directParseError) {
        // Not a direct JSON response, continue with extraction
        console.log('Response is not direct JSON, attempting to extract JSON...');
      }
      
      // Check for markdown code blocks (common in Gemini 2.0 responses)
      const markdownCodeBlockRegex = /```(?:json)?\s*\n([\s\S]+?)\n```/g;
      const codeBlockMatches = [...responseText.matchAll(markdownCodeBlockRegex)];
      
      if (codeBlockMatches && codeBlockMatches.length > 0) {
        // Try each markdown code block until one parses successfully
        for (const match of codeBlockMatches) {
          try {
            if (match[1]) {
              const result = JSON.parse(match[1].trim());
              // Verify this looks like our expected format - check for both old and new format keys
              if (result.timePatterns || result.dayPatterns || result.automationSuggestions || 
                  result.predictiveAutomations || result.seasonalAdjustments || result.anomalies) {
                console.log('Successfully extracted and parsed JSON from markdown code block');
                return this.normalizeResponseFormat(result);
              }
            }
          } catch (parseError) {
            console.log('Failed to parse markdown code block JSON, trying next method...');
          }
        }
      }
      
      // Try to find a valid JSON object in the response
      // This handles cases where the AI might add text before or after the JSON
      const jsonRegex = /\{(?:[^{}]|(?:\{(?:[^{}]|(?:\{[^{}]*\}))*\}))*\}/g;
      const jsonMatches = responseText.match(jsonRegex);
      
      if (jsonMatches && jsonMatches.length > 0) {
        // Try each matched JSON object until one parses successfully
        for (const match of jsonMatches) {
          try {
            const result = JSON.parse(match);
            // Verify this looks like our expected format - check for both old and new format keys
            if (result.timePatterns || result.dayPatterns || result.automationSuggestions || 
                result.predictiveAutomations || result.seasonalAdjustments || result.anomalies) {
              console.log('Successfully extracted and parsed JSON from response');
              return this.normalizeResponseFormat(result);
            }
          } catch (parseError) {
            // This match failed, try the next one
            console.log('Failed to parse a potential JSON match, trying next...');
          }
        }
      }
      
      // If we can't find valid JSON with the expected structure, try to reconstruct it
      console.log('No valid JSON found, constructing a response from text');
      
      // Extract potential data from the response using regex patterns
      const timePatterns = this.extractListItems(responseText, /time patterns|usage patterns|time of day/i);
      const dayPatterns = this.extractListItems(responseText, /day patterns|day of week|weekly patterns/i);
      const automationSuggestions = this.extractListItems(responseText, /automation|suggestions|recommend/i);
      const energySavingTips = this.extractListItems(responseText, /energy|saving|efficiency|tips/i);
      
      // Build a preferences object by looking for common smart home preference keywords
      const preferences = {};
      const preferenceKeywords = ['brightness', 'temperature', 'volume', 'color', 'mode', 'setting'];
      
      for (const keyword of preferenceKeywords) {
        const preferenceRegex = new RegExp(`${keyword}[^\\n\\.,]*[\\n\\.,]`, 'i');
        const match = responseText.match(preferenceRegex);
        if (match) {
          preferences[keyword] = match[0].trim();
        }
      }
      
      return {
        timePatterns: timePatterns.length > 0 ? timePatterns : ["Not enough data to determine time patterns"],
        dayPatterns: dayPatterns.length > 0 ? dayPatterns : ["Not enough data to determine day patterns"],
        preferences: Object.keys(preferences).length > 0 ? preferences : { "general": "No specific preferences detected" },
        automationSuggestions: automationSuggestions.length > 0 ? automationSuggestions : ["Set a basic schedule based on device type"],
        energySavingTips: energySavingTips.length > 0 ? energySavingTips : ["Turn off when not in use"]
      };
    } catch (error) {
      console.error('Error parsing AI response:', error);
      
      
      // Return a simple default structure
      return {
        timePatterns: ["Data analysis error - Not enough usage data"],
        dayPatterns: ["Data analysis error - Not enough usage data"],
        preferences: { "note": "Data analysis error" },
        automationSuggestions: ["Set up basic automation based on device type"],
        energySavingTips: ["Ensure device is turned off when not in use"]
      };
    }
  }
  
  // Helper function to extract list items from text
  /**
   * Normalizes the response format 
   * @param {Object} response - The parsed response from the AI
   * @returns {Object} - Normalized response object
   */
  normalizeResponseFormat(response) {
    const normalized = {
      timePatterns: response.timePatterns || [],
      dayPatterns: response.dayPatterns || [],
      preferences: response.preferences || {},
      automationSuggestions: [],
      energySavingTips: response.energySavingTips || []
    };
    
    // Handle new advanced format fields
    
    // Convert predictiveAutomations to automationSuggestions if present
    if (response.predictiveAutomations && Array.isArray(response.predictiveAutomations)) {
      normalized.automationSuggestions = response.predictiveAutomations;
    } else if (response.automationSuggestions && Array.isArray(response.automationSuggestions)) {
      normalized.automationSuggestions = response.automationSuggestions;
    }
    
    // Add new fields for advanced insights
    normalized.seasonalAdjustments = response.seasonalAdjustments || [];
    normalized.anomalies = response.anomalies || [];
    normalized.routines = response.routines || [];
    
    // Add score for confidence in predictions
    normalized.confidenceScore = response.confidenceScore || 0.85; // Default high confidence
    
    // Add timestamp for when analysis was performed
    normalized.analysisTimestamp = new Date().toISOString();
    
    return normalized;
  }

  extractListItems(text, sectionRegex) {
    try {
      // Find the section containing the list
      const sectionMatch = text.split(sectionRegex)[1];
      if (!sectionMatch) return [];
      
      // Look for the next section (usually starts with a number or heading)
      const nextSectionMatch = sectionMatch.match(/(?:\d+\.|\n\s*[A-Z][a-z]+|\n\s*#)/);
      const relevantText = nextSectionMatch ? sectionMatch.split(nextSectionMatch[0])[0] : sectionMatch;
      
      // Extract bullet points or numbered items using various patterns
      const listItems = [];
      const patterns = [
        /[•\-\*]\s*([^\n]+)/g,       // Bullet points
        /\d+\.\s*([^\n]+)/g,         // Numbered lists
        /\n\s*([A-Z][^\.]+\.)/g,     // Sentences starting with capital letter
        /[\n,]\s*([A-Za-z][^,\n]+)/g // Any phrase delimited by commas or newlines
      ];
      
      for (const pattern of patterns) {
        let match;
        while ((match = pattern.exec(relevantText)) !== null) {
          if (match[1] && match[1].length > 10) { // Only add substantial items
            listItems.push(match[1].trim());
          }
        }
        
        // If we found items with this pattern, stop trying others
        if (listItems.length > 0) break;
      }
      
      // If nothing else worked, just split by newlines and filter
      if (listItems.length === 0) {
        return relevantText
          .split('\n')
          .map(line => line.trim())
          .filter(line => line.length > 10 && !line.match(/^[A-Za-z]+:/)); // Avoid headers
      }
      
      return listItems;
    } catch (error) {
      console.warn('Error extracting list items:', error);
      return [];
    }
  }
  
  /**
   * Get insights for a specific device
   * @param {string} userId - User ID
   * @param {string} deviceId - Device ID
   * @param {string} deviceCategory - Device category for proper insights
   * @returns {Promise<Object>} - Device insights
   */
  async getDeviceInsights(userId, deviceId, deviceCategory = 'light') {
    console.log(`Getting insights for device ${deviceId}, user ${userId}, category: ${deviceCategory}`);
    
    // Check cache first for fast response
    const cacheKey = `insights_${deviceId}_${userId}_${deviceCategory}`;
    if (this.insightsCache && this.insightsCache[cacheKey]) {
      const cached = this.insightsCache[cacheKey];
      const cacheAge = Date.now() - cached.timestamp;
      // Use cache for 5 minutes to speed up responses
      if (cacheAge < 5 * 60 * 1000) {
        console.log('Returning cached insights for fast response');
        return cached.data;
      }
    }
    
    // Fast fallback if AI is not available
    if (!this.model) {
      console.log(`AI model not available, returning category-specific mock insights for ${deviceCategory}`);
      const mockInsights = this.createMockResponse(deviceCategory);
      this.cacheInsights(cacheKey, mockInsights);
      return {
        available: true,
        insights: mockInsights,
        source: 'mock_data'
      };
    }
    
    try {
      // Use the provided device category for accurate insights
      console.log(`Generating insights for ${deviceCategory} device`);
      
      // Return category-specific mock data immediately for responsive UI
      const quickInsights = this.createMockResponse(deviceCategory);
      this.cacheInsights(cacheKey, quickInsights);
      
      console.log(`Generated quick insights for category: ${deviceCategory}`);
      return {
        available: true,
        insights: quickInsights,
        source: 'optimized_mock'
      };
    } catch (error) {
      console.error('Error getting device insights:', error);
      
      // Return fallback insights for consistent user experience using correct category
      const fallbackInsights = this.createMockResponse(deviceCategory);
      return {
        available: true,
        insights: fallbackInsights,
        source: 'fallback'
      };
    }
  }

 
  /**
   * Get default automation suggestions for a device category
   * @param {string} category - Device category
   * @returns {Array} - Default suggestions
   */
  getDefaultSuggestions(category) {
    const suggestions = {
      light: [
        "Schedule lights to turn on at sunset",
        "Automatically dim lights 30 minutes before bedtime",
        "Create morning brightness routine",
        "Set energy-saving schedules during work hours"
      ],
      thermostat: [
        "Lower temperature when away from home",
        "Create sleep schedule for optimal comfort",
        "Adjust temperature based on weather forecast",
        "Set energy-saving mode during peak hours"
      ],
      security: [
        "Arm system automatically at bedtime",
        "Enable vacation mode when away for extended periods",
        "Create custom zones for different areas",
        "Set up smart notifications for unusual activity"
      ],
      entertainment: [
        "Create movie night scene with dimmed lights",
        "Set volume limits for late night hours",
        "Schedule auto-shutdown after periods of inactivity",
        "Integrate with other smart home devices"
      ],
      appliance: [
        "Schedule operation during off-peak energy hours",
        "Set maintenance reminders based on usage",
        "Create efficiency monitoring alerts",
        "Enable eco-mode for energy savings"
      ]
    };
    
    return suggestions[category] || suggestions.lighting;
  }
}

// Create singleton instance
const VertexAI = new VertexAIService();

// Export initialize function and singleton
module.exports = {
  VertexAI,
  initializeVertexAI: async () => await VertexAI.initialize()
};

