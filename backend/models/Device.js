const deviceCategories = [
  'light',
  'thermostat',
  'security',
  'entertainment',
  'appliance',
  'speaker',
  'other'
];

/**
 * Validates a device object
 * @param {Object} device - The device to validate
 * @returns {Object} - Result object with isValid and errors
 */
const validateDevice = (device) => {
  const errors = [];
  
  // Required fields
  if (!device.name) errors.push('Name is required');
  if (!device.category) errors.push('Category is required');
  if (!device.location) errors.push('Location is required');
  if (!device.userId) errors.push('User ID is required');
  
  // Field type validation
  if (device.name && typeof device.name !== 'string') 
    errors.push('Name must be a string');
  
  if (device.location && typeof device.location !== 'string') 
    errors.push('Location must be a string');
  
  if (device.category && !deviceCategories.includes(device.category.toLowerCase())) 
    errors.push(`Category must be one of: ${deviceCategories.join(', ')}`);
  
  if (device.isOn !== undefined && typeof device.isOn !== 'boolean') 
    errors.push('isOn must be a boolean');
  
  if (device.brightness !== undefined && (
    typeof device.brightness !== 'number' || 
    device.brightness < 0 || 
    device.brightness > 1
  )) 
    errors.push('Brightness must be a number between 0 and 1');
  
  if (device.properties && typeof device.properties !== 'object') 
    errors.push('Properties must be an object');
  
  return {
    isValid: errors.length === 0,
    errors
  };
};

/**
 * Creates a new device object with default values
 * @param {Object} deviceData - Initial device data
 * @returns {Object} - Complete device object with defaults
 */
const createDevice = (deviceData) => {
  return {
    name: deviceData.name,
    category: deviceData.category.toLowerCase(),
    location: deviceData.location,
    userId: deviceData.userId,
    isOn: deviceData.isOn || false,
    brightness: deviceData.brightness || 0.5,
    properties: deviceData.properties || {},
    createdAt: new Date().toISOString(),
    updatedAt: new Date().toISOString()
  };
};

module.exports = {
  validateDevice,
  createDevice,
  deviceCategories
};
