package com.smarthome.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006!"}, d2 = {"Lcom/smarthome/viewmodel/AddDeviceViewModel;", "Landroidx/lifecycle/ViewModel;", "deviceRepository", "Lcom/smarthome/data/repository/DeviceRepository;", "(Lcom/smarthome/data/repository/DeviceRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/smarthome/viewmodel/AddDeviceViewModel$AddDeviceState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "completeDeviceSetup", "connectToWifi", "moveToNextStep", "scanWifiNetworks", "selectDeviceType", "category", "Lcom/smarthome/data/model/DeviceCategory;", "selectWifiNetwork", "network", "Lcom/smarthome/data/model/WiFiNetwork;", "updateDeviceLocation", "location", "", "updateDeviceName", "name", "updateWifiPassword", "password", "AddDeviceState", "SetupStep", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AddDeviceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.repository.DeviceRepository deviceRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.smarthome.viewmodel.AddDeviceViewModel.AddDeviceState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.AddDeviceViewModel.AddDeviceState> state = null;
    
    @javax.inject.Inject
    public AddDeviceViewModel(@org.jetbrains.annotations.NotNull
    com.smarthome.data.repository.DeviceRepository deviceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.smarthome.viewmodel.AddDeviceViewModel.AddDeviceState> getState() {
        return null;
    }
    
    public final void selectDeviceType(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceCategory category) {
    }
    
    public final void moveToNextStep() {
    }
    
    public final void scanWifiNetworks() {
    }
    
    public final void selectWifiNetwork(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.WiFiNetwork network) {
    }
    
    public final void updateWifiPassword(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void updateDeviceName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void updateDeviceLocation(@org.jetbrains.annotations.NotNull
    java.lang.String location) {
    }
    
    public final void connectToWifi() {
    }
    
    private final void completeDeviceSetup() {
    }
    
    public final void clearError() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\'\u001a\u00020\rH\u00c6\u0003J\t\u0010(\u001a\u00020\rH\u00c6\u0003J\t\u0010)\u001a\u00020\rH\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003Jy\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\rH\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018\u00a8\u00061"}, d2 = {"Lcom/smarthome/viewmodel/AddDeviceViewModel$AddDeviceState;", "", "currentStep", "Lcom/smarthome/viewmodel/AddDeviceViewModel$SetupStep;", "selectedDeviceType", "Lcom/smarthome/data/model/DeviceCategory;", "availableNetworks", "", "Lcom/smarthome/data/model/WiFiNetwork;", "isScanning", "", "selectedNetwork", "wifiPassword", "", "deviceName", "deviceLocation", "isConnecting", "error", "(Lcom/smarthome/viewmodel/AddDeviceViewModel$SetupStep;Lcom/smarthome/data/model/DeviceCategory;Ljava/util/List;ZLcom/smarthome/data/model/WiFiNetwork;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAvailableNetworks", "()Ljava/util/List;", "getCurrentStep", "()Lcom/smarthome/viewmodel/AddDeviceViewModel$SetupStep;", "getDeviceLocation", "()Ljava/lang/String;", "getDeviceName", "getError", "()Z", "getSelectedDeviceType", "()Lcom/smarthome/data/model/DeviceCategory;", "getSelectedNetwork", "()Lcom/smarthome/data/model/WiFiNetwork;", "getWifiPassword", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class AddDeviceState {
        @org.jetbrains.annotations.NotNull
        private final com.smarthome.viewmodel.AddDeviceViewModel.SetupStep currentStep = null;
        @org.jetbrains.annotations.Nullable
        private final com.smarthome.data.model.DeviceCategory selectedDeviceType = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.smarthome.data.model.WiFiNetwork> availableNetworks = null;
        private final boolean isScanning = false;
        @org.jetbrains.annotations.Nullable
        private final com.smarthome.data.model.WiFiNetwork selectedNetwork = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String wifiPassword = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String deviceName = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String deviceLocation = null;
        private final boolean isConnecting = false;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String error = null;
        
        public AddDeviceState(@org.jetbrains.annotations.NotNull
        com.smarthome.viewmodel.AddDeviceViewModel.SetupStep currentStep, @org.jetbrains.annotations.Nullable
        com.smarthome.data.model.DeviceCategory selectedDeviceType, @org.jetbrains.annotations.NotNull
        java.util.List<com.smarthome.data.model.WiFiNetwork> availableNetworks, boolean isScanning, @org.jetbrains.annotations.Nullable
        com.smarthome.data.model.WiFiNetwork selectedNetwork, @org.jetbrains.annotations.NotNull
        java.lang.String wifiPassword, @org.jetbrains.annotations.NotNull
        java.lang.String deviceName, @org.jetbrains.annotations.NotNull
        java.lang.String deviceLocation, boolean isConnecting, @org.jetbrains.annotations.Nullable
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.smarthome.viewmodel.AddDeviceViewModel.SetupStep getCurrentStep() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.smarthome.data.model.DeviceCategory getSelectedDeviceType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.smarthome.data.model.WiFiNetwork> getAvailableNetworks() {
            return null;
        }
        
        public final boolean isScanning() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.smarthome.data.model.WiFiNetwork getSelectedNetwork() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getWifiPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDeviceName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDeviceLocation() {
            return null;
        }
        
        public final boolean isConnecting() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getError() {
            return null;
        }
        
        public AddDeviceState() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.smarthome.viewmodel.AddDeviceViewModel.SetupStep component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.smarthome.data.model.DeviceCategory component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.smarthome.data.model.WiFiNetwork> component3() {
            return null;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.smarthome.data.model.WiFiNetwork component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component8() {
            return null;
        }
        
        public final boolean component9() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.smarthome.viewmodel.AddDeviceViewModel.AddDeviceState copy(@org.jetbrains.annotations.NotNull
        com.smarthome.viewmodel.AddDeviceViewModel.SetupStep currentStep, @org.jetbrains.annotations.Nullable
        com.smarthome.data.model.DeviceCategory selectedDeviceType, @org.jetbrains.annotations.NotNull
        java.util.List<com.smarthome.data.model.WiFiNetwork> availableNetworks, boolean isScanning, @org.jetbrains.annotations.Nullable
        com.smarthome.data.model.WiFiNetwork selectedNetwork, @org.jetbrains.annotations.NotNull
        java.lang.String wifiPassword, @org.jetbrains.annotations.NotNull
        java.lang.String deviceName, @org.jetbrains.annotations.NotNull
        java.lang.String deviceLocation, boolean isConnecting, @org.jetbrains.annotations.Nullable
        java.lang.String error) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/smarthome/viewmodel/AddDeviceViewModel$SetupStep;", "", "(Ljava/lang/String;I)V", "SELECT_DEVICE_TYPE", "CONNECT_TO_WIFI", "CONFIGURE_DEVICE", "FINALIZE_SETUP", "SETUP_COMPLETE", "app_debug"})
    public static enum SetupStep {
        /*public static final*/ SELECT_DEVICE_TYPE /* = new SELECT_DEVICE_TYPE() */,
        /*public static final*/ CONNECT_TO_WIFI /* = new CONNECT_TO_WIFI() */,
        /*public static final*/ CONFIGURE_DEVICE /* = new CONFIGURE_DEVICE() */,
        /*public static final*/ FINALIZE_SETUP /* = new FINALIZE_SETUP() */,
        /*public static final*/ SETUP_COMPLETE /* = new SETUP_COMPLETE() */;
        
        SetupStep() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.smarthome.viewmodel.AddDeviceViewModel.SetupStep> getEntries() {
            return null;
        }
    }
}