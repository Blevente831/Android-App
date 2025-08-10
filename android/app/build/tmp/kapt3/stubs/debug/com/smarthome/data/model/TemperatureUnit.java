package com.smarthome.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/smarthome/data/model/TemperatureUnit;", "", "(Ljava/lang/String;I)V", "CELSIUS", "FAHRENHEIT", "app_debug"})
public enum TemperatureUnit {
    @com.squareup.moshi.Json(name = "celsius")
    /*public static final*/ CELSIUS /* = new CELSIUS() */,
    @com.squareup.moshi.Json(name = "fahrenheit")
    /*public static final*/ FAHRENHEIT /* = new FAHRENHEIT() */;
    
    TemperatureUnit() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.smarthome.data.model.TemperatureUnit> getEntries() {
        return null;
    }
}