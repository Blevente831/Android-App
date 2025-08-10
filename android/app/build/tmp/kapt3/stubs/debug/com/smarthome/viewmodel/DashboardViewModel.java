package com.smarthome.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/smarthome/viewmodel/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "deviceRepository", "Lcom/smarthome/data/repository/DeviceRepository;", "userRepository", "Lcom/smarthome/data/repository/UserRepository;", "(Lcom/smarthome/data/repository/DeviceRepository;Lcom/smarthome/data/repository/UserRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/smarthome/viewmodel/DashboardState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "calculateDeviceStats", "Lcom/smarthome/viewmodel/DeviceStats;", "devices", "", "Lcom/smarthome/data/model/Device;", "loadDashboard", "", "refreshDashboard", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.repository.DeviceRepository deviceRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.smarthome.viewmodel.DashboardState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.DashboardState> state = null;
    
    @javax.inject.Inject
    public DashboardViewModel(@org.jetbrains.annotations.NotNull
    com.smarthome.data.repository.DeviceRepository deviceRepository, @org.jetbrains.annotations.NotNull
    com.smarthome.data.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.DashboardState> getState() {
        return null;
    }
    
    public final void refreshDashboard() {
    }
    
    public final void loadDashboard() {
    }
    
    private final com.smarthome.viewmodel.DeviceStats calculateDeviceStats(java.util.List<com.smarthome.data.model.Device> devices) {
        return null;
    }
}