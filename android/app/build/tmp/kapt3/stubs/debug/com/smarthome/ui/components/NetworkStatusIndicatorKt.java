package com.smarthome.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\"\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u000b"}, d2 = {"AnimatedNetworkStatusIndicator", "", "isVisible", "", "connectionStatus", "Lcom/smarthome/ui/components/ConnectionStatus;", "connectionType", "Lcom/smarthome/ui/components/ConnectionType;", "modifier", "Landroidx/compose/ui/Modifier;", "NetworkStatusIndicator", "app_debug"})
public final class NetworkStatusIndicatorKt {
    
    @androidx.compose.runtime.Composable
    public static final void NetworkStatusIndicator(@org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionStatus connectionStatus, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionType connectionType, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Animated version of the network status indicator
     * Provides fade in/out animations when the indicator visibility changes
     * @deprecated Use EnhancedNetworkStatusIndicator instead which provides more visual feedback
     */
    @androidx.compose.runtime.Composable
    @java.lang.Deprecated
    public static final void AnimatedNetworkStatusIndicator(boolean isVisible, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionStatus connectionStatus, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.components.ConnectionType connectionType, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
}