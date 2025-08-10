-if class com.smarthome.data.model.UserPreferences
-keepnames class com.smarthome.data.model.UserPreferences
-if class com.smarthome.data.model.UserPreferences
-keep class com.smarthome.data.model.UserPreferencesJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.smarthome.data.model.UserPreferences
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.smarthome.data.model.UserPreferences
-keepclassmembers class com.smarthome.data.model.UserPreferences {
    public synthetic <init>(boolean,boolean,com.smarthome.data.model.TemperatureUnit,boolean,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
