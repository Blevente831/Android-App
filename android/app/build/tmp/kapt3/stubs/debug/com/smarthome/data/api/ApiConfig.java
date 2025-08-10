package com.smarthome.data.api;

/**
 * Configuration class for API endpoints and network settings
 * Used by the network interceptor and API service to determine
 * which endpoints to use based on current network conditions
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u000e\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020\bJ\u000e\u0010,\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020%2\u0006\u0010.\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u000eJ\u000e\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015\u00a8\u00064"}, d2 = {"Lcom/smarthome/data/api/ApiConfig;", "", "()V", "DEFAULT_CLOUD_ENDPOINT", "", "DEFAULT_LOCAL_ENDPOINT", "_aiOperationTimeout", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_cloudEndpointUrl", "_connectionTimeout", "_currentConnectionType", "Lcom/smarthome/ui/components/ConnectionType;", "_isConnected", "", "_localEndpointUrl", "_useAutoNetworkSwitching", "_useCloudBackend", "aiOperationTimeout", "Lkotlinx/coroutines/flow/StateFlow;", "getAiOperationTimeout", "()Lkotlinx/coroutines/flow/StateFlow;", "cloudEndpointUrl", "getCloudEndpointUrl", "connectionTimeout", "getConnectionTimeout", "currentConnectionType", "getCurrentConnectionType", "isConnected", "localEndpointUrl", "getLocalEndpointUrl", "useAutoNetworkSwitching", "getUseAutoNetworkSwitching", "useCloudBackend", "getUseCloudBackend", "getCurrentBaseUrl", "loadSettings", "", "saveSettings", "setAiOperationTimeout", "timeout", "setCloudEndpointUrl", "url", "setConnectionTimeout", "setLocalEndpointUrl", "setUseAutoNetworkSwitching", "enabled", "setUseCloudBackend", "updateConnectionStatus", "connected", "updateConnectionType", "connectionType", "app_debug"})
public final class ApiConfig {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DEFAULT_CLOUD_ENDPOINT = "https://smart-home-backend-467137186193.us-central1.run.app/";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DEFAULT_LOCAL_ENDPOINT = "http://192.168.1.5:8080/";
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _useCloudBackend = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> useCloudBackend = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _useAutoNetworkSwitching = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> useAutoNetworkSwitching = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _cloudEndpointUrl = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.String> cloudEndpointUrl = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _localEndpointUrl = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.String> localEndpointUrl = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _connectionTimeout = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> connectionTimeout = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _aiOperationTimeout = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> aiOperationTimeout = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<com.smarthome.ui.components.ConnectionType> _currentConnectionType = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<com.smarthome.ui.components.ConnectionType> currentConnectionType = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isConnected = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isConnected = null;
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.data.api.ApiConfig INSTANCE = null;
    
    private ApiConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getUseCloudBackend() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getUseAutoNetworkSwitching() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCloudEndpointUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getLocalEndpointUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getConnectionTimeout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getAiOperationTimeout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.smarthome.ui.components.ConnectionType> getCurrentConnectionType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isConnected() {
        return null;
    }
    
    /**
     * Update the cloud endpoint URL
     * @param url The new cloud endpoint URL
     */
    public final void setCloudEndpointUrl(@org.jetbrains.annotations.NotNull
    java.lang.String url) {
    }
    
    /**
     * Update the local endpoint URL
     * @param url The new local endpoint URL
     */
    public final void setLocalEndpointUrl(@org.jetbrains.annotations.NotNull
    java.lang.String url) {
    }
    
    /**
     * Enable or disable the use of cloud backend
     * @param enabled Whether to use cloud backend
     */
    public final void setUseCloudBackend(boolean enabled) {
    }
    
    /**
     * Enable or disable auto network switching
     * @param enabled Whether to automatically switch between networks
     */
    public final void setUseAutoNetworkSwitching(boolean enabled) {
    }
    
    /**
     * Set the connection timeout in milliseconds
     * @param timeout Connection timeout in milliseconds
     */
    public final void setConnectionTimeout(int timeout) {
    }
    
    /**
     * Set the AI operation timeout in milliseconds
     * @param timeout AI operation timeout in milliseconds
     */
    public final void setAiOperationTimeout(int timeout) {
    }
    
    /**
     * Update the current connection type
     * @param connectionType The current connection type
     */
    public final void updateConnectionType(@org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionType connectionType) {
    }
    
    /**
     * Update the connection status
     * @param connected Whether the device is connected
     */
    public final void updateConnectionStatus(boolean connected) {
    }
    
    /**
     * Get the current base URL to use based on settings and network status
     * @return The appropriate base URL
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentBaseUrl() {
        return null;
    }
    
    /**
     * Load settings from preferences
     * Should be called during app startup
     */
    public final void loadSettings() {
    }
    
    /**
     * Save current settings to preferences
     * Should be called whenever settings are updated
     */
    public final void saveSettings() {
    }
}