package com.smarthome.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0004H\u0007\u001a6\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0004H\u0007\u001a,\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0019H\u0007\u001a\"\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006 "}, d2 = {"DashboardScreen", "", "onDeviceClick", "Lkotlin/Function1;", "", "onAddDeviceClick", "Lkotlin/Function0;", "viewModel", "Lcom/smarthome/viewmodel/DashboardViewModel;", "ErrorCard", "errorMessage", "FavoriteDeviceCard", "deviceId", "deviceName", "deviceCategory", "isActive", "", "onClick", "GreetingCard", "userName", "QuickStatsRow", "devicesCount", "", "activeDevicesCount", "categories", "", "StatCard", "title", "value", "modifier", "Landroidx/compose/ui/Modifier;", "StatusIndicator", "app_debug"})
public final class DashboardScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeviceClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddDeviceClick, @org.jetbrains.annotations.NotNull
    com.smarthome.viewmodel.DashboardViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void GreetingCard(@org.jetbrains.annotations.NotNull
    java.lang.String userName) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void QuickStatsRow(int devicesCount, int activeDevicesCount, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> categories) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void StatCard(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void FavoriteDeviceCard(@org.jetbrains.annotations.NotNull
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull
    java.lang.String deviceName, @org.jetbrains.annotations.NotNull
    java.lang.String deviceCategory, boolean isActive, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void StatusIndicator(boolean isActive) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ErrorCard(@org.jetbrains.annotations.NotNull
    java.lang.String errorMessage) {
    }
}