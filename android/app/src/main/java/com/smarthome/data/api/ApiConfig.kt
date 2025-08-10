package com.smarthome.data.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smarthome.ui.components.ConnectionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


object ApiConfig {

    private const val DEFAULT_CLOUD_ENDPOINT = "https://smart-home-backend-467137186193.us-central1.run.app/"
    private const val DEFAULT_LOCAL_ENDPOINT = "http://192.168.1.5:8080/"

    // Connection settings
    private val _useCloudBackend = MutableStateFlow(true)
    val useCloudBackend: StateFlow<Boolean> = _useCloudBackend.asStateFlow()

    private val _useAutoNetworkSwitching = MutableStateFlow(false) // Disabled by default
    val useAutoNetworkSwitching: StateFlow<Boolean> = _useAutoNetworkSwitching.asStateFlow()

    // Endpoint URLs
    private val _cloudEndpointUrl = MutableStateFlow(DEFAULT_CLOUD_ENDPOINT)
    val cloudEndpointUrl: StateFlow<String> = _cloudEndpointUrl.asStateFlow()

    private val _localEndpointUrl = MutableStateFlow(DEFAULT_LOCAL_ENDPOINT)
    val localEndpointUrl: StateFlow<String> = _localEndpointUrl.asStateFlow()

    private val _connectionTimeout = MutableStateFlow(30000) // Default 30 seconds for AI operations
    val connectionTimeout: StateFlow<Int> = _connectionTimeout.asStateFlow()

    // Special timeout for AI operations which need more time
    private val _aiOperationTimeout = MutableStateFlow(60000) // 60 seconds for AI insights
    val aiOperationTimeout: StateFlow<Int> = _aiOperationTimeout.asStateFlow()

    // Current network state
    private val _currentConnectionType = MutableStateFlow(ConnectionType.WIFI)
    val currentConnectionType: StateFlow<ConnectionType> = _currentConnectionType.asStateFlow()

    private val _isConnected = MutableStateFlow(false)
    val isConnected: StateFlow<Boolean> = _isConnected.asStateFlow()

    fun updateConnectionType(connectionType: ConnectionType) {
        _currentConnectionType.value = connectionType
    }

    fun updateConnectionStatus(connected: Boolean) {
        _isConnected.value = connected
    }


    fun getCurrentBaseUrl(): String {
        // Always prefer cloud endpoint by default (more reliable)
        return if (_useAutoNetworkSwitching.value) {
            when (_currentConnectionType.value) {
                ConnectionType.WIFI -> if (_useCloudBackend.value) _cloudEndpointUrl.value else _localEndpointUrl.value
                ConnectionType.CELLULAR -> _cloudEndpointUrl.value
                ConnectionType.NONE -> _cloudEndpointUrl.value
            }
        } else {
            if (_useCloudBackend.value) _cloudEndpointUrl.value else _localEndpointUrl.value
        }
    }


    fun loadSettings() {

    }


    fun saveSettings() {
    }
}