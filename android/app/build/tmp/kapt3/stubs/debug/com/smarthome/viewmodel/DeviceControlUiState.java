package com.smarthome.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003JK\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/smarthome/viewmodel/DeviceControlUiState;", "", "device", "Lcom/smarthome/data/model/Device;", "isLoading", "", "error", "", "hasPendingUpdates", "insights", "Lcom/smarthome/data/model/DeviceInsights;", "isLoadingInsights", "(Lcom/smarthome/data/model/Device;ZLjava/lang/String;ZLcom/smarthome/data/model/DeviceInsights;Z)V", "getDevice", "()Lcom/smarthome/data/model/Device;", "getError", "()Ljava/lang/String;", "getHasPendingUpdates", "()Z", "getInsights", "()Lcom/smarthome/data/model/DeviceInsights;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class DeviceControlUiState {
    @org.jetbrains.annotations.Nullable
    private final com.smarthome.data.model.Device device = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    private final boolean hasPendingUpdates = false;
    @org.jetbrains.annotations.Nullable
    private final com.smarthome.data.model.DeviceInsights insights = null;
    private final boolean isLoadingInsights = false;
    
    public DeviceControlUiState(@org.jetbrains.annotations.Nullable
    com.smarthome.data.model.Device device, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, boolean hasPendingUpdates, @org.jetbrains.annotations.Nullable
    com.smarthome.data.model.DeviceInsights insights, boolean isLoadingInsights) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.smarthome.data.model.Device getDevice() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean getHasPendingUpdates() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.smarthome.data.model.DeviceInsights getInsights() {
        return null;
    }
    
    public final boolean isLoadingInsights() {
        return false;
    }
    
    public DeviceControlUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.smarthome.data.model.Device component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.smarthome.data.model.DeviceInsights component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.viewmodel.DeviceControlUiState copy(@org.jetbrains.annotations.Nullable
    com.smarthome.data.model.Device device, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, boolean hasPendingUpdates, @org.jetbrains.annotations.Nullable
    com.smarthome.data.model.DeviceInsights insights, boolean isLoadingInsights) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}