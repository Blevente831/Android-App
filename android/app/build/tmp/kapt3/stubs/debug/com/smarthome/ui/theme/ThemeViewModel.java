package com.smarthome.ui.theme;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/smarthome/ui/theme/ThemeViewModel;", "Landroidx/lifecycle/ViewModel;", "preferencesManager", "Lcom/smarthome/ui/theme/PreferencesManager;", "themeEventBus", "Lcom/smarthome/ui/theme/ThemeEventBus;", "(Lcom/smarthome/ui/theme/PreferencesManager;Lcom/smarthome/ui/theme/ThemeEventBus;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/smarthome/ui/theme/ThemeState;", "currentActivity", "Landroid/app/Activity;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "getThemeEventBus$app_debug", "()Lcom/smarthome/ui/theme/ThemeEventBus;", "loadThemeSettings", "", "refreshTheme", "setThemeMode", "themeMode", "Lcom/smarthome/ui/theme/ThemeMode;", "activity", "updateCurrentActivity", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ThemeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.ui.theme.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.ui.theme.ThemeEventBus themeEventBus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.smarthome.ui.theme.ThemeState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.smarthome.ui.theme.ThemeState> state = null;
    @org.jetbrains.annotations.Nullable
    private android.app.Activity currentActivity;
    
    @javax.inject.Inject
    public ThemeViewModel(@org.jetbrains.annotations.NotNull
    com.smarthome.ui.theme.PreferencesManager preferencesManager, @org.jetbrains.annotations.NotNull
    com.smarthome.ui.theme.ThemeEventBus themeEventBus) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.theme.ThemeEventBus getThemeEventBus$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.smarthome.ui.theme.ThemeState> getState() {
        return null;
    }
    
    private final void loadThemeSettings() {
    }
    
    /**
     * Update the current activity reference to ensure consistent recreation
     */
    public final void updateCurrentActivity(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    /**
     * Sets the theme mode and immediately applies it
     * @param themeMode The new theme mode to apply
     * @param activity The current activity to recreate for immediate theme change
     */
    public final void setThemeMode(@org.jetbrains.annotations.NotNull
    com.smarthome.ui.theme.ThemeMode themeMode, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
    }
    
    /**
     * Force reload theme from preferences
     * Useful when app is returned to foreground
     */
    public final void refreshTheme() {
    }
}