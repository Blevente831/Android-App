const { CloudStorage } = require('../services/cloudStorage');
const { VertexAI } = require('../services/vertexAI');
const { Firestore } = require('../services/firestore');
const deviceTypes = require('../config/deviceTypes.json');
const { v4: uuidv4 } = require('uuid');

// Get all devices for a user
const getAllDevices = async (req, res) => {
  try {
    const userId = req.user.id;
    
    // Get devices from Firestore
    const devicesRef = Firestore.collection('devices');
    const snapshot = await devicesRef.where('userId', '==', userId).get();
    
    if (snapshot.empty) {
      return res.json([]);
    }
    
    const devices = [];
    snapshot.forEach(doc => {
      devices.push({ id: doc.id, ...doc.data() });
    });
    
    res.json(devices);
  } catch (error) {
    console.error('Error getting devices:', error);
    res.status(500).json({ error: true, message: 'Failed to fetch devices' });
  }
};

// Get a device by ID
const getDeviceById = async (req, res) => {
  try {
    const userId = req.user.id;
    const deviceId = req.params.id;
    
    const deviceRef = Firestore.collection('devices').doc(deviceId);
    const doc = await deviceRef.get();
    
    if (!doc.exists) {
      return res.status(404).json({ error: true, message: 'Device not found' });
    }
    
    const device = doc.data();
    
    // Check if device belongs to the requesting user
    if (device.userId !== userId) {
      return res.status(403).json({ error: true, message: 'Access denied' });
    }
    
    res.json({ id: doc.id, ...device });
  } catch (error) {
    console.error('Error getting device:', error);
    res.status(500).json({ error: true, message: 'Failed to fetch device' });
  }
};

// Create a new device
const createDevice = async (req, res) => {
  try {
    const userId = req.user.id;
    const { name, category, location, properties } = req.body;
    
    // Validate required fields
    if (!name || !category || !location) {
      return res.status(400).json({ 
        error: true, 
        message: 'Name, category, and location are required' 
      });
    }
    
    // Validate device category against supported types
    const validCategories = Object.keys(deviceTypes);
    if (!validCategories.includes(category.toLowerCase())) {
      return res.status(400).json({ 
        error: true, 
        message: `Invalid category. Must be one of: ${validCategories.join(', ')}` 
      });
    }
    
    // Create device object
    const newDevice = {
      name,
      category: category.toLowerCase(),
      location,
      userId,
      isOn: false,
      brightness: 0.5, // Default brightness for all devices
      properties: properties || {},
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString()
    };
    
    // Add to Firestore
    const deviceRef = Firestore.collection('devices').doc();
    await deviceRef.set(newDevice);
    
    // Store device creation event in Cloud Storage for ML analysis
    const eventData = {
      type: 'device_created',
      deviceId: deviceRef.id,
      userId,
      timestamp: new Date().toISOString(),
      deviceInfo: {
        name,
        category,
        location
      }
    };
    
    await CloudStorage.storeEvent(eventData);
    
    // Return the created device
    res.status(201).json({ 
      id: deviceRef.id, 
      ...newDevice 
    });
  } catch (error) {
    console.error('Error creating device:', error);
    res.status(500).json({ error: true, message: 'Failed to create device' });
  }
};

// Update a device
const updateDevice = async (req, res) => {
  try {
    const userId = req.user.id;
    const deviceId = req.params.id;
    const { name, location, isOn, brightness, properties } = req.body;
    
    // Get the device to update
    const deviceRef = Firestore.collection('devices').doc(deviceId);
    const doc = await deviceRef.get();
    
    if (!doc.exists) {
      return res.status(404).json({ error: true, message: 'Device not found' });
    }
    
    const device = doc.data();
    
    // Check if device belongs to the requesting user
    if (device.userId !== userId) {
      return res.status(403).json({ error: true, message: 'Access denied' });
    }
    
    // Prepare update data
    const updateData = {
      updatedAt: new Date().toISOString()
    };
    
    if (name !== undefined) updateData.name = name;
    if (location !== undefined) updateData.location = location;
    if (isOn !== undefined) updateData.isOn = isOn;
    if (brightness !== undefined) updateData.brightness = brightness;
    
    if (properties) {
      updateData.properties = { ...device.properties, ...properties };
    }
    
    // Update device in Firestore
    await deviceRef.update(updateData);
    
    // Store device update event in Cloud Storage for ML analysis
    const eventData = {
      type: 'device_updated',
      deviceId,
      userId,
      timestamp: new Date().toISOString(),
      updates: updateData
    };
    
    await CloudStorage.storeEvent(eventData);
    
    // If device state changed, send to Vertex AI for pattern analysis
    if (isOn !== undefined || brightness !== undefined || properties) {
      const deviceState = {
        deviceId,
        category: device.category,
        isOn: isOn !== undefined ? isOn : device.isOn,
        brightness: brightness !== undefined ? brightness : device.brightness,
        properties: updateData.properties || device.properties,
        timestamp: new Date().toISOString(),
        location: location || device.location
      };
      
      // Process device state asynchronously
      VertexAI.processDeviceState(userId, deviceState)
        .catch(err => console.error('Error processing device state:', err));
    }
    
    // Return updated device
    const updatedDevice = {
      id: deviceId,
      ...device,
      ...updateData
    };
    
    res.json(updatedDevice);
  } catch (error) {
    console.error('Error updating device:', error);
    res.status(500).json({ error: true, message: 'Failed to update device' });
  }
};

// Delete a device
const deleteDevice = async (req, res) => {
  try {
    const userId = req.user.id;
    const deviceId = req.params.id;
    
    // Get the device to delete
    const deviceRef = Firestore.collection('devices').doc(deviceId);
    const doc = await deviceRef.get();
    
    if (!doc.exists) {
      return res.status(404).json({ error: true, message: 'Device not found' });
    }
    
    const device = doc.data();
    
    // Check if device belongs to the requesting user
    if (device.userId !== userId) {
      return res.status(403).json({ error: true, message: 'Access denied' });
    }
    
    // Delete device from Firestore
    await deviceRef.delete();
    
    // Store device deletion event in Cloud Storage
    const eventData = {
      type: 'device_deleted',
      deviceId,
      userId,
      timestamp: new Date().toISOString(),
      deviceInfo: {
        name: device.name,
        category: device.category,
        location: device.location
      }
    };
    
    await CloudStorage.storeEvent(eventData);
    
    res.json({ success: true });
  } catch (error) {
    console.error('Error deleting device:', error);
    res.status(500).json({ error: true, message: 'Failed to delete device' });
  }
};

// Get behavior insights for a device
const getDeviceInsights = async (req, res) => {
  try {
    const userId = req.user.id;
    const deviceId = req.params.id;
    
    console.log(`Fast insights request for device ${deviceId} by user ${userId}`);
    
    // Get device category for proper insights
    let deviceCategory = 'light'; // Default fallback
    
    try {
      // Quick category lookup from Firestore
      const deviceRef = Firestore.collection('devices').doc(deviceId);
      const doc = await deviceRef.get();
      
      if (doc.exists && doc.data().category) {
        // Map Android enum values to backend category strings
        const categoryMapping = {
          'LIGHT': 'light',
          'THERMOSTAT': 'thermostat', 
          'SECURITY': 'security',
          'ENTERTAINMENT': 'entertainment',
          'APPLIANCE': 'appliance',
          'SPEAKER': 'speaker',
          'OTHER': 'light'
        };
        
        const rawCategory = doc.data().category;
        deviceCategory = categoryMapping[rawCategory] || rawCategory.toLowerCase() || 'light';
        console.log(`Retrieved device category: ${rawCategory} -> ${deviceCategory}`);
      }
    } catch (categoryError) {
      console.log('Using default category due to lookup error:', categoryError.message);
    }
    
    // Get insights from optimized Vertex AI service with proper category
    const insights = await VertexAI.getDeviceInsights(userId, deviceId, deviceCategory);
    
    console.log(`Insights delivered in optimized mode: ${insights.source}`);
    res.json(insights);
  } catch (error) {
    console.error('Error getting device insights:', error);
    
    // Return category-specific fallback response instead of error
    const categorySpecificInsights = VertexAI.createMockResponse(deviceCategory || 'light');
    const fallbackInsights = {
      available: true,
      insights: categorySpecificInsights,
      source: 'fast_fallback'
    };
    
    res.json(fallbackInsights);
  }
};

// Get usage history for a device
const getDeviceHistory = async (req, res) => {
  try {
    const userId = req.user.id;
    const deviceId = req.params.id;
    
    // Check if device exists and belongs to user
    const deviceRef = Firestore.collection('devices').doc(deviceId);
    const doc = await deviceRef.get();
    
    if (!doc.exists) {
      return res.status(404).json({ error: true, message: 'Device not found' });
    }
    
    if (doc.data().userId !== userId) {
      return res.status(403).json({ error: true, message: 'Access denied' });
    }
    
    // Get events from Cloud Storage
    const events = await CloudStorage.getDeviceEvents(deviceId);
    
    // Format events for frontend
    const history = events.map(event => {
      return {
        timestamp: event.timestamp,
        type: event.type,
        changes: event.updates || event.deviceInfo || {}
      };
    });
    
    res.json(history);
  } catch (error) {
    console.error('Error getting device history:', error);
    res.status(500).json({ error: true, message: 'Failed to get device history' });
  }
};

// Update device automations
const updateDeviceAutomations = async (req, res) => {
  try {
    const userId = req.user.id;
    const deviceId = req.params.id;
    const { automations } = req.body;
    
    if (!automations || !Array.isArray(automations)) {
      return res.status(400).json({ 
        error: true, 
        message: 'Automations array is required' 
      });
    }
    
    // Check if device exists and belongs to user
    const deviceRef = Firestore.collection('devices').doc(deviceId);
    const doc = await deviceRef.get();
    
    if (!doc.exists) {
      return res.status(404).json({ error: true, message: 'Device not found' });
    }
    
    if (doc.data().userId !== userId) {
      return res.status(403).json({ error: true, message: 'Access denied' });
    }
    
    // Update automations in Firestore
    await deviceRef.update({
      automations,
      updatedAt: new Date().toISOString()
    });
    
    res.json({ success: true, automations });
  } catch (error) {
    console.error('Error updating device automations:', error);
    res.status(500).json({ error: true, message: 'Failed to update automations' });
  }
};

module.exports = {
  getAllDevices,
  getDeviceById,
  createDevice,
  updateDevice,
  deleteDevice,
  getDeviceInsights,
  getDeviceHistory,
  updateDeviceAutomations
};
