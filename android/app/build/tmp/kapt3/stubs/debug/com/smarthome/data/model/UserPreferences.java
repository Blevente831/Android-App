package com.smarthome.data.model;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/smarthome/data/model/UserPreferences;", "", "darkMode", "", "notificationsEnabled", "temperatureUnit", "Lcom/smarthome/data/model/TemperatureUnit;", "autoDiscovery", "(ZZLcom/smarthome/data/model/TemperatureUnit;Z)V", "getAutoDiscovery", "()Z", "getDarkMode", "getNotificationsEnabled", "getTemperatureUnit", "()Lcom/smarthome/data/model/TemperatureUnit;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class UserPreferences {
    private final boolean darkMode = false;
    private final boolean notificationsEnabled = false;
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.model.TemperatureUnit temperatureUnit = null;
    private final boolean autoDiscovery = false;
    
    public UserPreferences(@com.squareup.moshi.Json(name = "dark_mode")
    boolean darkMode, @com.squareup.moshi.Json(name = "notifications_enabled")
    boolean notificationsEnabled, @com.squareup.moshi.Json(name = "temperature_unit")
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.TemperatureUnit temperatureUnit, @com.squareup.moshi.Json(name = "auto_discovery")
    boolean autoDiscovery) {
        super();
    }
    
    public final boolean getDarkMode() {
        return false;
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.model.TemperatureUnit getTemperatureUnit() {
        return null;
    }
    
    public final boolean getAutoDiscovery() {
        return false;
    }
    
    public UserPreferences() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.model.TemperatureUnit component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.model.UserPreferences copy(@com.squareup.moshi.Json(name = "dark_mode")
    boolean darkMode, @com.squareup.moshi.Json(name = "notifications_enabled")
    boolean notificationsEnabled, @com.squareup.moshi.Json(name = "temperature_unit")
    @org.jetbrains.annotations.NotNull
    com.smarthome.data.model.TemperatureUnit temperatureUnit, @com.squareup.moshi.Json(name = "auto_discovery")
    boolean autoDiscovery) {
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