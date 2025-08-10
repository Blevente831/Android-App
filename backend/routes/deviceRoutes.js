const express = require('express');
const router = express.Router();
const deviceController = require('../controllers/deviceController');
 const { authenticateToken } = require('../middleware/auth');

// All device routes require authentication
router.use(authenticateToken);

// Get all devices
router.get('/', deviceController.getAllDevices);

// Get a single device by ID
router.get('/:id', deviceController.getDeviceById);

// Create a new device
router.post('/', deviceController.createDevice);

// Update a device
router.put('/:id', deviceController.updateDevice);

// Delete a device
router.delete('/:id', deviceController.deleteDevice);

// Get device behavior insights
router.get('/:id/insights', deviceController.getDeviceInsights);

// Get device usage history
router.get('/:id/history', deviceController.getDeviceHistory);

// Update device automations
router.post('/:id/automations', deviceController.updateDeviceAutomations);

module.exports = router;
