package com.smarthome;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/smarthome/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "deviceStateManager", "Lcom/smarthome/data/utils/DeviceStateManager;", "getDeviceStateManager", "()Lcom/smarthome/data/utils/DeviceStateManager;", "setDeviceStateManager", "(Lcom/smarthome/data/utils/DeviceStateManager;)V", "deviceStateRestoreManager", "Lcom/smarthome/data/utils/DeviceStateRestoreManager;", "getDeviceStateRestoreManager", "()Lcom/smarthome/data/utils/DeviceStateRestoreManager;", "setDeviceStateRestoreManager", "(Lcom/smarthome/data/utils/DeviceStateRestoreManager;)V", "sharedToggleStateManager", "Lcom/smarthome/data/utils/SharedToggleStateManager;", "getSharedToggleStateManager", "()Lcom/smarthome/data/utils/SharedToggleStateManager;", "setSharedToggleStateManager", "(Lcom/smarthome/data/utils/SharedToggleStateManager;)V", "themeViewModel", "Lcom/smarthome/ui/theme/ThemeViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject
    public com.smarthome.data.utils.DeviceStateManager deviceStateManager;
    @javax.inject.Inject
    public com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager;
    @javax.inject.Inject
    public com.smarthome.data.utils.DeviceStateRestoreManager deviceStateRestoreManager;
    private com.smarthome.ui.theme.ThemeViewModel themeViewModel;
    
    public MainActivity() {
        super(0);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.DeviceStateManager getDeviceStateManager() {
        return null;
    }
    
    public final void setDeviceStateManager(@org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.SharedToggleStateManager getSharedToggleStateManager() {
        return null;
    }
    
    public final void setSharedToggleStateManager(@org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.SharedToggleStateManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.DeviceStateRestoreManager getDeviceStateRestoreManager() {
        return null;
    }
    
    public final void setDeviceStateRestoreManager(@org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateRestoreManager p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
}