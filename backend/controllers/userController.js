const { CloudStorage } = require('../services/cloudStorage');
const userService = require('../services/UserService');
const jwt = require('jsonwebtoken');
const { v4: uuidv4 } = require('uuid');

// Secret for JWT signing
const JWT_SECRET = process.env.JWT_SECRET || 'your-secret-key';

// Register a new user
const register = async (req, res) => {
  try {
    const { username, email, password } = req.body;

    if (!username || !email || !password) {
      return res.status(400).json({ 
        error: true, 
        message: 'Username, email, and password are required' 
      });
    }

    // FIX: await here
    const existingUser = await userService.findUserByEmail(email);

    if (existingUser) {
      return res.status(400).json({ 
        error: true, 
        message: 'User with this email already exists' 
      });
    }

    const userId = uuidv4();
    const newUser = await userService.createUser({
      id: userId,
      username,
      email,
      password
    });

    const token = jwt.sign({ id: userId }, JWT_SECRET, { expiresIn: '30d' });

    const { password: _, ...userWithoutPassword } = newUser;

    res.status(201).json({
      token,
      user: userWithoutPassword
    });

  } catch (error) {
    console.error('Error registering user:', error);
    res.status(500).json({ error: true, message: 'Failed to register user' });
  }
};


// Login user
const login = async (req, res) => {
  try {
    const { email, password } = req.body;
    
    // Validate input
    if (!email || !password) {
      return res.status(400).json({ 
        error: true, 
        message: 'Email and password are required' 
      });
    }
    
    // Find user by email
    const user = await userService.findUserByEmail(email);
    
    if (!user) {
      return res.status(401).json({ 
        error: true, 
        message: 'Invalid credentials' 
      });
    }
    
    // Verify password
    const isMatch = await userService.comparePassword(password, user.password);
    
    if (!isMatch) {
      return res.status(401).json({ 
        error: true, 
        message: 'Invalid credentials' 
      });
    }
    
    // Create and return JWT token
    const token = jwt.sign({ id: user.id }, JWT_SECRET, { expiresIn: '30d' });
    
    // Remove password from response
    const { password: _, ...userWithoutPassword } = user;
    
    res.json({
      token,
      user: userWithoutPassword
    });
  } catch (error) {
    console.error('Error logging in user:', error);
    res.status(500).json({ error: true, message: 'Failed to login' });
  }
};

// Get user profile
const getUserProfile = async (req, res) => {
  try {
    const userId = req.user.id;
    
    const user = await userService.getUserById(userId);
    
    if (!user) {
      return res.status(404).json({ error: true, message: 'User not found' });
    }
    
    // Remove password from response
    const { password, ...userWithoutPassword } = user;
    
    res.json(userWithoutPassword);
  } catch (error) {
    console.error('Error getting user profile:', error);
    res.status(500).json({ error: true, message: 'Failed to get user profile' });
  }
};

// Update user profile
const updateUserProfile = async (req, res) => {
  try {
    const userId = req.user.id;
    const { username, preferences } = req.body;
    
    // Check if user exists
    const user = await userService.getUserById(userId);
    
    if (!user) {
      return res.status(404).json({ error: true, message: 'User not found' });
    }
    
    const updateData = {
      updatedAt: new Date().toISOString()
    };
    
    if (username !== undefined) updateData.username = username;
   
    
    if (preferences) {
      updateData.preferences = {
        ...user.preferences,
        ...preferences
      };
    }
    
    // Update user
    const updatedUser = await userService.updateUser(userId, updateData);
    
    // Remove password from response
    const { password, ...userWithoutPassword } = updatedUser;
    
    res.json(userWithoutPassword);
  } catch (error) {
    console.error('Error updating user profile:', error);
    res.status(500).json({ error: true, message: 'Failed to update user profile' });
  }
};

// Update user preferences
const updateUserPreferences = async (req, res) => {
  try {
    const userId = req.user.id;
    const { preferences } = req.body;
    
    if (!preferences) {
      return res.status(400).json({ 
        error: true, 
        message: 'Preferences object is required' 
      });
    }
    
    // Check if user exists
    const user = userService.getUserById(userId);
    
    if (!user) {
      return res.status(404).json({ error: true, message: 'User not found' });
    }
    
    const updateData = {
      preferences: {
        ...user.preferences,
        ...preferences
      },
      updatedAt: new Date().toISOString()
    };
    
    // Update user preferences
    const updatedUser =await userService.updateUser(userId, updateData);
    
    // Remove password from response
    const { password, ...userWithoutPassword } = updatedUser;
    
    res.json(userWithoutPassword);
  } catch (error) {
    console.error('Error updating user preferences:', error);
    res.status(500).json({ error: true, message: 'Failed to update preferences' });
  }
};

// Get user devices
const getUserDevices = async (req, res) => {
  try {
    const userId = req.user.id;
    
    // For now, return an empty array since we don't have device storage yet
    // In a real implementation, we would fetch devices from storage
    const devices = [];
    
    res.json(devices);
  } catch (error) {
    console.error('Error getting user devices:', error);
    res.status(500).json({ error: true, message: 'Failed to get user devices' });
  }
};

// Delete user account
const deleteUserAccount = async (req, res) => {
  try {
    const userId = req.user.id;
    
    // Delete user from in-memory storage
    const deleted = userService.deleteUser(userId);
    
    if (!deleted) {
      return res.status(404).json({ error: true, message: 'User not found' });
    }
    
    // Store user deletion event in Cloud Storage
    const eventData = {
      type: 'user_deleted',
      userId,
      timestamp: new Date().toISOString()
    };
    
    await CloudStorage.storeEvent(eventData);
    
    res.json({ success: true, message: 'User account deleted successfully' });
  } catch (error) {
    console.error('Error deleting user account:', error);
    res.status(500).json({ error: true, message: 'Failed to delete user account' });
  }
};

module.exports = {
  register,
  login,
  getUserProfile,
  updateUserProfile,
  updateUserPreferences,
  getUserDevices,
  deleteUserAccount
};
