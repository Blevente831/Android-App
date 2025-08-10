package com.smarthome.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\t\u0010\"\u001a\u00020\fH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003JW\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/smarthome/viewmodel/DashboardState;", "", "isLoading", "", "error", "", "userName", "connectionStatus", "Lcom/smarthome/ui/components/ConnectionStatus;", "connectionType", "Lcom/smarthome/ui/components/ConnectionType;", "deviceStats", "Lcom/smarthome/viewmodel/DeviceStats;", "favoriteDevices", "", "Lcom/smarthome/data/model/Device;", "(ZLjava/lang/String;Ljava/lang/String;Lcom/smarthome/ui/components/ConnectionStatus;Lcom/smarthome/ui/components/ConnectionType;Lcom/smarthome/viewmodel/DeviceStats;Ljava/util/List;)V", "getConnectionStatus", "()Lcom/smarthome/ui/components/ConnectionStatus;", "getConnectionType", "()Lcom/smarthome/ui/components/ConnectionType;", "getDeviceStats", "()Lcom/smarthome/viewmodel/DeviceStats;", "getError", "()Ljava/lang/String;", "getFavoriteDevices", "()Ljava/util/List;", "()Z", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class DashboardState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String userName = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.ui.components.ConnectionStatus connectionStatus = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.ui.components.ConnectionType connectionType = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.viewmodel.DeviceStats deviceStats = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.smarthome.data.model.Device> favoriteDevices = null;
    
    public DashboardState(boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionStatus connectionStatus, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionType connectionType, @org.jetbrains.annotations.NotNull
    com.smarthome.viewmodel.DeviceStats deviceStats, @org.jetbrains.annotations.NotNull
    java.util.List<com.smarthome.data.model.Device> favoriteDevices) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.components.ConnectionStatus getConnectionStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.components.ConnectionType getConnectionType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.viewmodel.DeviceStats getDeviceStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.smarthome.data.model.Device> getFavoriteDevices() {
        return null;
    }
    
    public DashboardState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.components.ConnectionStatus component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.components.ConnectionType component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.viewmodel.DeviceStats component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.smarthome.data.model.Device> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.viewmodel.DashboardState copy(boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionStatus connectionStatus, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionType connectionType, @org.jetbrains.annotations.NotNull
    com.smarthome.viewmodel.DeviceStats deviceStats, @org.jetbrains.annotations.NotNull
    java.util.List<com.smarthome.data.model.Device> favoriteDevices) {
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