package com.smarthome.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u00a6@\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H&\u00a8\u0006\u001d"}, d2 = {"Lcom/smarthome/data/repository/DeviceRepository;", "", "addDevice", "Lcom/smarthome/data/model/Device;", "deviceRequest", "Lcom/smarthome/data/model/DeviceRequest;", "(Lcom/smarthome/data/model/DeviceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDevices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedDeviceState", "getDevice", "getDeviceInsights", "Lcom/smarthome/data/model/DeviceInsights;", "getDevices", "scanWifiNetworks", "Lcom/smarthome/data/model/WiFiNetwork;", "updateDevice", "updateRequest", "Lcom/smarthome/data/model/DeviceUpdateRequest;", "(Ljava/lang/String;Lcom/smarthome/data/model/DeviceUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalDeviceState", "", "device", "app_debug"})
public abstract interface DeviceRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDevices(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.Device>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllDevices(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.Device>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addDevice(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceRequest deviceRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceUpdateRequest updateRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteDevice(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object scanWifiNetworks(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.WiFiNetwork>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDeviceInsights(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.DeviceInsights> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract com.smarthome.data.model.Device getCachedDeviceState(@org.jetbrains.annotations.NotNull
    java.lang.String id);
    
    public abstract void updateLocalDeviceState(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device);
}