package com.smarthome.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00152\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\"\u0010\u001f\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010 \u001a\u00020!H\u00a7@\u00a2\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00132\b\b\u0001\u0010 \u001a\u00020$H\u00a7@\u00a2\u0006\u0002\u0010%\u00a8\u0006&"}, d2 = {"Lcom/smarthome/data/api/ApiService;", "", "addDevice", "Lcom/smarthome/data/model/Device;", "deviceRequest", "Lcom/smarthome/data/model/DeviceRequest;", "(Lcom/smarthome/data/model/DeviceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDevice", "getDeviceInsights", "Lcom/smarthome/data/model/DeviceInsights;", "getDevices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserProfile", "Lcom/smarthome/data/model/User;", "login", "Lcom/smarthome/data/model/AuthResponse;", "loginRequest", "Lcom/smarthome/data/model/LoginRequest;", "(Lcom/smarthome/data/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "registerRequest", "Lcom/smarthome/data/model/RegisterRequest;", "(Lcom/smarthome/data/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanWifiNetworks", "Lcom/smarthome/data/model/WiFiNetwork;", "updateDevice", "updateRequest", "Lcom/smarthome/data/model/DeviceUpdateRequest;", "(Ljava/lang/String;Lcom/smarthome/data/model/DeviceUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "Lcom/smarthome/data/model/UpdateUserRequest;", "(Lcom/smarthome/data/model/UpdateUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "api/users/login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.AuthResponse> $completion);
    
    @retrofit2.http.POST(value = "api/users/register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.RegisterRequest registerRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.AuthResponse> $completion);
    
    @retrofit2.http.GET(value = "api/users/profile")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserProfile(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion);
    
    @retrofit2.http.PUT(value = "api/users/profile")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUserProfile(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.UpdateUserRequest updateRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion);
    
    @retrofit2.http.GET(value = "api/devices")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDevices(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.Device>> $completion);
    
    @retrofit2.http.GET(value = "api/devices/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDevice(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion);
    
    @retrofit2.http.POST(value = "api/devices")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addDevice(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceRequest deviceRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion);
    
    @retrofit2.http.PUT(value = "api/devices/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateDevice(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceUpdateRequest updateRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.Device> $completion);
    
    @retrofit2.http.DELETE(value = "api/devices/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteDevice(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @retrofit2.http.GET(value = "api/wifi/scan")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object scanWifiNetworks(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.smarthome.data.model.WiFiNetwork>> $completion);
    
    @retrofit2.http.GET(value = "api/devices/{id}/insights")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDeviceInsights(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.DeviceInsights> $completion);
}