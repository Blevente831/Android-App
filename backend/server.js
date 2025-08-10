const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const fs = require('fs');
const path = require('path');
const deviceRoutes = require('./routes/deviceRoutes');
const userRoutes = require('./routes/userRoutes');
const { initializeFirestore } = require('./services/firestore');
const { initializeCloudStorage } = require('./services/cloudStorage');
const { initializeVertexAI } = require('./services/vertexAI');

// Initialize app
const app = express();
const PORT = process.env.PORT || 8080; 


// Initialize all services in parallel
const initializeServices = async () => {
  try {
    console.log('Starting service initialization...');
    
    // Run all initializations in parallel with better error handling
    const [firestoreResult, storageResult, vertexResult] = await Promise.allSettled([
      initializeFirestore(),
      initializeCloudStorage(),
      initializeVertexAI()
    ]);
    
    // Log results
    let firestoreInitialized = false;
    if (firestoreResult.status === 'fulfilled') {
      firestoreInitialized = true;
      console.log('Firestore initialized successfully');
    } else {
      console.error('Error initializing Firestore:', firestoreResult.reason);
      if (useInMemory) {
        console.log('Using in-memory database due to Firestore error');
        firestoreInitialized = true; // Consider it initialized since we'll use in-memory
      }
    }
    
    let storageInitialized = false;
    if (storageResult.status === 'fulfilled') {
      storageInitialized = true;
      console.log('Cloud Storage initialized successfully');
    } else {
      console.error('Error initializing Cloud Storage:', storageResult.reason);
    }
    
    let vertexInitialized = false;
    if (vertexResult.status === 'fulfilled') {
      vertexInitialized = true;
      console.log('Vertex AI initialized successfully');
    } else {
      console.error('Error initializing Vertex AI:', vertexResult.reason);
    }
    
    console.log('Service initialization complete. Some services may have failed but the app will continue.');
    return { 
      success: firestoreInitialized || useInMemory, 
      firestore: firestoreInitialized, 
      storage: storageInitialized, 
      vertex: vertexInitialized 
    };
  } catch (error) {
    console.error('Unexpected error during service initialization:', error);
    return { success: false, error: error.message };
  }
};

// Start initialization but don't wait for it to complete before starting server
initializeServices().then(result => {
  if (result.success) {
    console.log('Initialization result: Success');
  } else {
    console.log('Initialization result: Failed, but continuing', result.error ? `(${result.error})` : '');
    
    if (useInMemory) {
      console.log('Using in-memory implementations for any failed services');
    }
  }
});

// Middleware
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Logging middleware
app.use((req, res, next) => {
  console.log(`${new Date().toISOString()} - ${req.method} ${req.url}`);
  next();
});

// Root endpoint with API information
app.get('/', (req, res) => {
  res.status(200).json({
    api: 'Smart Home Intelligence Backend API',
    version: '1.0.0',
    status: 'running',
    endpoints: [
      '/api/devices',
      '/api/users'
    ]
  });
});

// Routes
app.use('/api/devices', deviceRoutes);
app.use('/api/users', userRoutes.authRoutes); // Auth routes that don't need authentication
app.use('/api/users', userRoutes.userRoutes); // User routes that require authentication



// Error handling middleware
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).json({
    error: true,
    message: err.message || 'Internal Server Error'
  });
});

// Start server
app.listen(PORT, '0.0.0.0', () => {
  console.log(`Server running on http://0.0.0.0:${PORT}`);
});

// Handle  shutdown
process.on('SIGTERM', () => {
  console.log('SIGTERM received, shutting down gracefully');
  process.exit(0);
});

process.on('SIGINT', () => {
  console.log('SIGINT received, shutting down gracefully');
  process.exit(0);
});
