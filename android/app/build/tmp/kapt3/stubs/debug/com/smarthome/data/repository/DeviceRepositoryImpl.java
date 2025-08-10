package com.smarthome.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0096@\u00a2\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/smarthome/data/repository/DeviceRepositoryImpl;", "Lcom/smarthome/data/repository/DeviceRepository;", "apiService", "Lcom/smarthome/data/api/ApiService;", "deviceStateManager", "Lcom/smarthome/data/utils/DeviceStateManager;", "networkErrorHandler", "Lcom/smarthome/data/utils/NetworkErrorHandler;", "(Lcom/smarthome/data/api/ApiService;Lcom/smarthome/data/utils/DeviceStateManager;Lcom/smarthome/data/utils/NetworkErrorHandler;)V", "addDevice", "Lcom/smarthome/data/model/Device;", "deviceRequest", "Lcom/smarthome/data/model/DeviceRequest;", "(Lcom/smarthome/data/model/DeviceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDevices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedDeviceState", "getDefaultSuggestionsForCategory", "category", "getDevice", "getDeviceInsights", "Lcom/smarthome/data/model/DeviceInsights;", "getDevices", "scanWifiNetworks", "Lcom/smarthome/data/model/WiFiNetwork;", "updateDevice", "updateRequest", "Lcom/smarthome/data/model/DeviceUpdateRequest;", "(Ljava/lang/String;Lcom/smarthome/data/model/DeviceUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalDeviceState", "", "device", "app_debug"})
public final class DeviceRepositoryImpl implements com.smarthome.data.repository.DeviceRepository {
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.utils.DeviceStateManager deviceStateManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.utils.NetworkErrorHandler networkErrorHandler = null;
    
    @javax.inject.Inject
    public DeviceRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.smarthome.data.api.ApiService apiService, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateManager deviceStateManager, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.NetworkErrorHandler networkErrorHandler) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getDevices(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.Device>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllDevices(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.Device>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addDevice(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceRequest deviceRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceUpdateRequest updateRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object scanWifiNetworks(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.WiFiNetwork>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getDeviceInsights(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.DeviceInsights> $completion) {
        return null;
    }
    
    /**
     * Get default suggestions for a device category when AI insights are unavailable
     */
    private final java.util.List<java.lang.String> getDefaultSuggestionsForCategory(java.lang.String category) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public com.smarthome.data.model.Device getCachedDeviceState(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
    
    @java.lang.Override
    public void updateLocalDeviceState(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device) {
    }
}