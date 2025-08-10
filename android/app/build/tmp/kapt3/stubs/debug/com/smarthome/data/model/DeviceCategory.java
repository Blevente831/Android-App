package com.smarthome.data.model;

/**
 * Represents categories of smart devices
 *
 * Note: These must match the backend categories to avoid 404 errors
 * Backend categories: 'lighting', 'thermostat', 'security', 'entertainment', 'appliance'
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/smarthome/data/model/DeviceCategory;", "", "Ljava/io/Serializable;", "displayName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "LIGHT", "THERMOSTAT", "SECURITY", "ENTERTAINMENT", "APPLIANCE", "SPEAKER", "OTHER", "Companion", "app_debug"})
public enum DeviceCategory implements java.io.Serializable {
    @com.squareup.moshi.Json(name = "light")
    /*public static final*/ LIGHT /* = new LIGHT(null) */,
    @com.squareup.moshi.Json(name = "thermostat")
    /*public static final*/ THERMOSTAT /* = new THERMOSTAT(null) */,
    @com.squareup.moshi.Json(name = "security")
    /*public static final*/ SECURITY /* = new SECURITY(null) */,
    @com.squareup.moshi.Json(name = "entertainment")
    /*public static final*/ ENTERTAINMENT /* = new ENTERTAINMENT(null) */,
    @com.squareup.moshi.Json(name = "appliance")
    /*public static final*/ APPLIANCE /* = new APPLIANCE(null) */,
    @com.squareup.moshi.Json(name = "speaker")
    /*public static final*/ SPEAKER /* = new SPEAKER(null) */,
    @com.squareup.moshi.Json(name = "other")
    /*public static final*/ OTHER /* = new OTHER(null) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.data.model.DeviceCategory.Companion Companion = null;
    
    DeviceCategory(java.lang.String displayName) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.smarthome.data.model.DeviceCategory> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/smarthome/data/model/DeviceCategory$Companion;", "", "()V", "fromString", "Lcom/smarthome/data/model/DeviceCategory;", "value", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.smarthome.data.model.DeviceCategory fromString(@org.jetbrains.annotations.NotNull
        java.lang.String value) {
            return null;
        }
    }
}