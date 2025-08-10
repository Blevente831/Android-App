const jwt = require('jsonwebtoken');
const userService = require('../services/UserService');

// Secret for JWT verification
const JWT_SECRET = process.env.JWT_SECRET || 'your-secret-key';

/**
 * Middleware to authenticate JWT token
 * Verifies the token and attaches the user to the request
 */
const authenticateToken = async (req, res, next) => {
  // Get token from header
  const authHeader = req.headers['authorization'];
  const token = authHeader && authHeader.split(' ')[1]; // Bearer TOKEN
  
  if (!token) {
    return res.status(401).json({ 
      error: true, 
      message: 'Access denied. No token provided.' 
    });
  }
  
  try {
    // Verify token
    const decoded = jwt.verify(token, JWT_SECRET);
    
    // Get user from in-memory service
    const user = userService.getUserById(decoded.id);
    
    
    if (!user) {
      return res.status(401).json({ 
        error: true, 
        message: 'Invalid token. User not found.' 
      });
    }
    
    // Attach user to request
    req.user = { id: decoded.id };
    
    next();
  } catch (error) {
    console.error('Token verification error:', error.message);
    
    if (error.name === 'TokenExpiredError') {
      return res.status(401).json({ 
        error: true, 
        message: 'Token expired' 
      });
    }
    
    res.status(401).json({ 
      error: true, 
      message: 'Invalid token' 
    });
  }
};

/**
 * Generates a JWT token for a user
 * @param {string} userId - The ID of the user
 * @returns {string} - JWT token
 */
const generateToken = (userId) => {
  return jwt.sign({ id: userId }, JWT_SECRET, { expiresIn: '30d' });
};

module.exports = {
  authenticateToken,
  generateToken
};
