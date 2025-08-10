package com.smarthome.ui.theme;

/**
 * Global theme event bus to communicate theme changes across the app
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/smarthome/ui/theme/ThemeEventBus;", "", "()V", "listeners", "", "Lkotlin/Function0;", "", "notifyThemeChanged", "registerListener", "listener", "unregisterListener", "app_debug"})
public final class ThemeEventBus {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>> listeners = null;
    
    @javax.inject.Inject
    public ThemeEventBus() {
        super();
    }
    
    public final void registerListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    public final void unregisterListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    public final void notifyThemeChanged() {
    }
}