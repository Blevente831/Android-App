package com.smarthome.ui.theme;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/smarthome/ui/theme/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "clearAuthToken", "", "getAuthToken", "", "getThemeMode", "Lcom/smarthome/ui/theme/ThemeMode;", "saveAuthToken", "token", "saveThemeMode", "themeMode", "Companion", "app_debug"})
public final class PreferencesManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREFERENCES_NAME = "smart_home_preferences";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_THEME_MODE = "theme_mode";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_AUTH_TOKEN = "auth_token";
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.ui.theme.PreferencesManager.Companion Companion = null;
    
    @javax.inject.Inject
    public PreferencesManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void saveAuthToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAuthToken() {
        return null;
    }
    
    public final void clearAuthToken() {
    }
    
    public final void saveThemeMode(@org.jetbrains.annotations.NotNull
    com.smarthome.ui.theme.ThemeMode themeMode) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.theme.ThemeMode getThemeMode() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/smarthome/ui/theme/PreferencesManager$Companion;", "", "()V", "KEY_AUTH_TOKEN", "", "KEY_THEME_MODE", "PREFERENCES_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}