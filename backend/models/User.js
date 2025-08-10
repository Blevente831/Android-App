const bcrypt = require('bcryptjs');

/**
 * Validates a user object
 * @param {Object} user - The user to validate
 * @returns {Object} - Result object with isValid and errors
 */
const validateUser = (user) => {
  const errors = [];
  
  // Required fields
  if (!user.username) errors.push('Username is required');
  if (!user.email) errors.push('Email is required');
  
  // Email format validation
  if (user.email && !/^\S+@\S+\.\S+$/.test(user.email)) 
    errors.push('Email format is invalid');
  
  // Username validation
  if (user.username && (user.username.length < 3 || user.username.length > 50)) 
    errors.push('Username must be between 3 and 50 characters');
  
  // Password validation for new users
  if (user.password !== undefined) {
    if (user.password.length < 6) 
      errors.push('Password must be at least 6 characters');
  }
  
  return {
    isValid: errors.length === 0,
    errors
  };
};

/**
 * Creates a new user object with default values
 * @param {Object} userData - Initial user data
 * @returns {Object} - Complete user object with defaults
 */
const createUser = async (userData) => {
  // Hash password if provided
  let hashedPassword = userData.password;
  if (userData.password && !userData.password.startsWith('$2')) {
    const salt = await bcrypt.genSalt(10);
    hashedPassword = await bcrypt.hash(userData.password, salt);
  }
  
  return {
    id: userData.id,
    username: userData.username,
    email: userData.email.toLowerCase(),
    password: hashedPassword,
    firstName: userData.firstName || '',
    lastName: userData.lastName || '',
    createdAt: userData.createdAt || new Date().toISOString(),
    updatedAt: new Date().toISOString(),
    preferences: userData.preferences || {
      darkMode: false,
      notificationsEnabled: true,
      temperatureUnit: 'fahrenheit',
      autoDiscovery: true
    }
  };
};

/**
 * Compare a password with the hashed password
 * @param {string} password - The plain text password to check
 * @param {string} hashedPassword - The hashed password to compare against
 * @returns {Promise<boolean>} - True if password matches
 */
const comparePassword = async (password, hashedPassword) => {
  return await bcrypt.compare(password, hashedPassword);
};

module.exports = {
  validateUser,
  createUser,
  comparePassword
};
