/**
 * Firestore User Service
 * 
 * This service provides Firestore-based storage and authentication
 * for persistent user management.
  **/

const bcrypt = require('bcryptjs');
const { v4: uuidv4 } = require('uuid');
const { Firestore } = require('./firestore');

 // Firestore collection reference
 const db = getFirestore();
 const usersCollection = db.collection('users');

/**
 * Find a user by email
 * @param {string} email - User email
 * @returns {Object|null} - User object or null if not found
 */
const findUserByEmail = async (email) => {
  if (!email) return null;
  const usersCollection = Firestore.collection('users');

  const normalizedEmail = email.toLowerCase();
  const snapshot = await usersCollection.where('email', '==', normalizedEmail).limit(1).get();
  
  if (snapshot.empty) {
    return null;
  }

  const doc = snapshot.docs[0];
  return { id: doc.id, ...doc.data() };
};

/**
 * Create a new user
 * @param {Object} userData - User data
 * @returns {Object} - Created user object
 */
const createUser = async (userData) => {
 try{ const userId = userData.id || uuidv4();
  const usersCollection = Firestore.collection('users');

  // Hash password if needed
  let hashedPassword = userData.password;
  if (userData.password && !userData.password.startsWith('$2')) {
    const salt = await bcrypt.genSalt(10);
    hashedPassword = await bcrypt.hash(userData.password, salt);
  }
  
  const user = {
    username: userData.username,
    email: userData.email.toLowerCase(),
    password: hashedPassword,
    createdAt: userData.createdAt || new Date().toISOString(),
    updatedAt: new Date().toISOString(),
    preferences: userData.preferences || {
      darkMode: false,
      notificationsEnabled: true,
      temperatureUnit: 'fahrenheit',
      autoDiscovery: true
    }
  };

  await usersCollection.doc(userId).set(user);
  console.log(' User saved to Firestore:', userId);
    return { id: userId, ...user };
}catch (error) {
    console.error(' Failed to save user to Firestore:', error);
    throw error;
  }
  
 // return { id: userId, ...user };
};

/**
 * Get a user by ID
 * @param {string} userId - User ID
 * @returns {Object|null} - User object or null if not found
 */
const getUserById = async (userId) => {
  if (!userId) return null;
  const usersCollection = Firestore.collection('users');

  const doc = await usersCollection.doc(userId).get();
  
  if (!doc.exists) {
    return null;
  }

  return { id: doc.id, ...doc.data() };
};

/**
 * Update a user
 * @param {string} userId - User ID
 * @param {Object} updateData - Data to update
 * @returns {Object|null} - Updated user or null if not found
 */
const updateUser = async (userId, updateData) => {
  if (!userId) return null;
  const usersCollection = Firestore.collection('users');

  const docRef = usersCollection.doc(userId);
  const doc = await docRef.get();

  if (!doc.exists) {
    return null;
  }

  const user = doc.data();
  
  const updatedUser = {
    ...user,
    ...updateData,
    updatedAt: new Date().toISOString()
  };

  // Handle nested preferences update
  if (updateData.preferences) {
    updatedUser.preferences = {
      ...user.preferences,
      ...updateData.preferences
    };
  }

  await docRef.update(updatedUser);

  return { id: userId, ...updatedUser };
};

/**
 * Delete a user
 * @param {string} userId - User ID
 * @returns {boolean} - True if user was deleted, false otherwise
 */
const deleteUser = async (userId) => {
  if (!userId) return false;
  const usersCollection = Firestore.collection('users');

  await usersCollection.doc(userId).delete();
  return true;
};

/**
 * Compare a password with the hashed password
 * @param {string} password - Plain text password
 * @param {string} hashedPassword - Hashed password
 * @returns {Promise<boolean>} - True if passwords match
 */
const comparePassword = async (password, hashedPassword) => {
  return await bcrypt.compare(password, hashedPassword);
};

// Export the Firestore-based user service
module.exports = {
  findUserByEmail,
  createUser,
  getUserById,
  updateUser,
  deleteUser,
  comparePassword
};
