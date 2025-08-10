package com.smarthome.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a4\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a&\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a4\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a2\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u001e\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u001e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0016\u0010\u001f\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\b\u0010 \u001a\u00020\u0001H\u0007\u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0007\u001a\u0010\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\'"}, d2 = {"DeviceStatusSummary", "", "devices", "", "Lcom/smarthome/data/model/Device;", "DevicesScreen", "onDeviceClick", "Lkotlin/Function1;", "", "onAddDeviceClick", "Lkotlin/Function0;", "viewModel", "Lcom/smarthome/viewmodel/DevicesViewModel;", "ModernCategoryChip", "category", "Lcom/smarthome/data/model/DeviceCategory;", "isSelected", "", "onClick", "ModernDeviceCategoryFilters", "categories", "selectedCategory", "onCategorySelected", "ModernDeviceListItem", "device", "onToggle", "ModernEmptyDevicesList", "message", "onAddDevice", "ModernErrorMessage", "onRetry", "ModernFloatingActionButton", "ModernLoadingState", "ModernTopAppBar", "title", "deviceCount", "", "getCategoryIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "app_debug"})
public final class DevicesScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void DevicesScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeviceClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddDeviceClick, @org.jetbrains.annotations.NotNull
    com.smarthome.viewmodel.DevicesViewModel viewModel) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void ModernTopAppBar(@org.jetbrains.annotations.NotNull
    java.lang.String title, int deviceCount) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernFloatingActionButton(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernDeviceCategoryFilters(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.smarthome.data.model.DeviceCategory> categories, @org.jetbrains.annotations.Nullable
    com.smarthome.data.model.DeviceCategory selectedCategory, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.smarthome.data.model.DeviceCategory, kotlin.Unit> onCategorySelected) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernCategoryChip(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceCategory category, boolean isSelected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.ui.graphics.vector.ImageVector getCategoryIcon(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.DeviceCategory category) {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    public static final void DeviceStatusSummary(@org.jetbrains.annotations.NotNull
    java.util.List<com.smarthome.data.model.Device> devices) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernDeviceListItem(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.Device device, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggle) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernLoadingState() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernErrorMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ModernEmptyDevicesList(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddDevice) {
    }
}