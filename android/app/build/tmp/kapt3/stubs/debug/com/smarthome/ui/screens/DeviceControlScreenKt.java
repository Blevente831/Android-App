package com.smarthome.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007\u001aH\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aP\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00062\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0007\u001a,\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u00b4\u0001\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00062\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0018\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0007\u001a\u0010\u0010\'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0007\u001a$\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a<\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007\u001aM\u0010-\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00062\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u00100\u001a\u00020\u00112\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e\u00a2\u0006\u0002\b2H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a8\u00106\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a.\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u0010\u0010<\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a$\u0010=\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a<\u0010>\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0007\u001a8\u0010?\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a.\u0010A\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006D"}, d2 = {"ApplianceControls", "", "device", "Lcom/smarthome/data/model/Device;", "onToggleDevice", "Lkotlin/Function1;", "", "onSetTimer", "", "AutomationSuggestionItem", "title", "", "description", "onClick", "Lkotlin/Function0;", "highlight", "chipColor", "Landroidx/compose/ui/graphics/Color;", "AutomationSuggestionItem-xwkQ0AY", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZJ)V", "AutomationSuggestions", "insights", "Lcom/smarthome/data/model/DeviceInsights;", "isLoadingInsights", "onCreateAutomation", "onRefresh", "DayChip", "day", "selected", "onSelectedChange", "DeviceControlContent", "onUpdateBrightness", "", "onUpdateTemperature", "onUpdateVolume", "DeviceControlScreen", "deviceId", "navController", "Landroidx/navigation/NavController;", "DeviceInfoCard", "DeviceInfoRow", "label", "value", "DeviceStatusCard", "EntertainmentControls", "ExpandableSection", "expanded", "onToggle", "iconTint", "content", "Landroidx/compose/runtime/Composable;", "ExpandableSection-42QJj7c", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;JLkotlin/jvm/functions/Function0;)V", "GenericControls", "LightingControls", "onBrightnessChange", "LightingModeCard", "name", "isSelected", "isEnabled", "SectionHeader", "SecurityControls", "SpeakerControl", "ThermostatControls", "onTemperatureChange", "ThermostatModeCard", "getSuggestionDescription", "getSuggestionTitle", "app_debug"})
public final class DeviceControlScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void DeviceControlScreen(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DeviceControlContent(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onUpdateBrightness, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onUpdateTemperature, @org.jetbrains.annotations.Nullable
    com.smarthome.data.model.DeviceInsights insights, boolean isLoadingInsights, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCreateAutomation, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onRefresh, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onUpdateVolume, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSetTimer) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DeviceStatusCard(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LightingControls(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onBrightnessChange, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void LightingModeCard(@org.jetbrains.annotations.NotNull
    java.lang.String name, boolean isSelected, boolean isEnabled, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ThermostatControls(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onTemperatureChange, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void ThermostatModeCard(@org.jetbrains.annotations.NotNull
    java.lang.String name, boolean isSelected, boolean isEnabled, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SecurityControls(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void EntertainmentControls(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onUpdateVolume) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ApplianceControls(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSetTimer) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SpeakerControl(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onUpdateVolume) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DeviceInfoCard(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DeviceInfoRow(@org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void GenericControls(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggleDevice) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AutomationSuggestions(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.Nullable
    com.smarthome.data.model.DeviceInsights insights, boolean isLoadingInsights, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCreateAutomation, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onRefresh) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SectionHeader(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @androidx.compose.runtime.Composable
    private static final java.lang.String getSuggestionTitle(com.smarthome.data.model.Device device) {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    private static final java.lang.String getSuggestionDescription(com.smarthome.data.model.Device device) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void DayChip(@org.jetbrains.annotations.NotNull
    java.lang.String day, boolean selected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSelectedChange) {
    }
}