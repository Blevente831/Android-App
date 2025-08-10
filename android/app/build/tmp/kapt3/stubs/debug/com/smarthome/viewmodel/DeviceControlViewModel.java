package com.smarthome.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u0017J\u0010\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010\'\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020%R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/smarthome/viewmodel/DeviceControlViewModel;", "Landroidx/lifecycle/ViewModel;", "deviceId", "", "deviceRepository", "Lcom/smarthome/data/repository/DeviceRepository;", "deviceStateRestoreManager", "Lcom/smarthome/data/utils/DeviceStateRestoreManager;", "sharedToggleStateManager", "Lcom/smarthome/data/utils/SharedToggleStateManager;", "(Ljava/lang/String;Lcom/smarthome/data/repository/DeviceRepository;Lcom/smarthome/data/utils/DeviceStateRestoreManager;Lcom/smarthome/data/utils/SharedToggleStateManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/smarthome/viewmodel/DeviceControlUiState;", "activeUpdateJob", "Lkotlinx/coroutines/Job;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteDevice", "", "onComplete", "Lkotlin/Function1;", "", "loadDevice", "forceRefresh", "onCleared", "refresh", "refreshInsights", "setTimer", "minutes", "", "toggleDevice", "isOn", "updateBrightness", "brightness", "", "updateTemperature", "temperature", "updateVolume", "volume", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DeviceControlViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String deviceId = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.repository.DeviceRepository deviceRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.utils.DeviceStateRestoreManager deviceStateRestoreManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.smarthome.viewmodel.DeviceControlUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.DeviceControlUiState> uiState = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job activeUpdateJob;
    
    @javax.inject.Inject
    public DeviceControlViewModel(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    com.smarthome.data.repository.DeviceRepository deviceRepository, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateRestoreManager deviceStateRestoreManager, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.DeviceControlUiState> getUiState() {
        return null;
    }
    
    public final void loadDevice(boolean forceRefresh) {
    }
    
    public final void toggleDevice(boolean isOn) {
    }
    
    public final void updateBrightness(float brightness) {
    }
    
    public final void updateTemperature(float temperature) {
    }
    
    public final void updateVolume(float volume) {
    }
    
    public final void setTimer(int minutes) {
    }
    
    public final void refresh() {
    }
    
    public final void refreshInsights() {
    }
    
    public final void deleteDevice(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onComplete) {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
}