-if class com.smarthome.data.model.UpdateUserRequest
-keepnames class com.smarthome.data.model.UpdateUserRequest
-if class com.smarthome.data.model.UpdateUserRequest
-keep class com.smarthome.data.model.UpdateUserRequestJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.smarthome.data.model.UpdateUserRequest
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.smarthome.data.model.UpdateUserRequest
-keepclassmembers class com.smarthome.data.model.UpdateUserRequest {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.String,com.smarthome.data.model.UserPreferences,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
