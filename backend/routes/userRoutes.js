const express = require('express');
const authRouter = express.Router();
const userRouter = express.Router();
const userController = require('../controllers/userController');
const { authenticateToken } = require('../middleware/auth');
const cors = require('cors');
const app = express();
app.use(cors()); // This allows requests from all origins

// Auth routes (no auth required)
authRouter.post('/register', userController.register);
authRouter.post('/login', userController.login);

// User routes (auth required)
userRouter.use(authenticateToken);

// Get user profile
userRouter.get('/profile', userController.getUserProfile);

// Update user profile
userRouter.put('/profile', userController.updateUserProfile);

// Update user preferences
userRouter.put('/preferences', userController.updateUserPreferences);

// Get user devices
userRouter.get('/devices', userController.getUserDevices);

// Delete user account
userRouter.delete('/account', userController.deleteUserAccount);

module.exports = {
  authRoutes: authRouter,
  userRoutes: userRouter
};
