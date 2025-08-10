-if class com.smarthome.data.model.User
-keepnames class com.smarthome.data.model.User
-if class com.smarthome.data.model.User
-keep class com.smarthome.data.model.UserJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.smarthome.data.model.User
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.smarthome.data.model.User
-keepclassmembers class com.smarthome.data.model.User {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.String,java.lang.String,com.smarthome.data.model.UserPreferences,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
