package com.smarthome.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/smarthome/viewmodel/DevicesViewModel;", "Landroidx/lifecycle/ViewModel;", "deviceRepository", "Lcom/smarthome/data/repository/DeviceRepository;", "sharedToggleStateManager", "Lcom/smarthome/data/utils/SharedToggleStateManager;", "deviceStateRestoreManager", "Lcom/smarthome/data/utils/DeviceStateRestoreManager;", "(Lcom/smarthome/data/repository/DeviceRepository;Lcom/smarthome/data/utils/SharedToggleStateManager;Lcom/smarthome/data/utils/DeviceStateRestoreManager;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/smarthome/viewmodel/DevicesScreenState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadDevices", "", "refreshDevices", "toggleDevice", "deviceId", "", "isOn", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DevicesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.repository.DeviceRepository deviceRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.utils.DeviceStateRestoreManager deviceStateRestoreManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.smarthome.viewmodel.DevicesScreenState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.DevicesScreenState> state = null;
    
    @javax.inject.Inject
    public DevicesViewModel(@org.jetbrains.annotations.NotNull
    com.smarthome.data.repository.DeviceRepository deviceRepository, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateRestoreManager deviceStateRestoreManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.DevicesScreenState> getState() {
        return null;
    }
    
    public final void loadDevices() {
    }
    
    public final void toggleDevice(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, boolean isOn) {
    }
    
    /**
     * Refresh the devices list and ensure all states are synchronized
     */
    public final void refreshDevices() {
    }
}