-if class com.smarthome.data.model.LoginRequest
-keepnames class com.smarthome.data.model.LoginRequest
-if class com.smarthome.data.model.LoginRequest
-keep class com.smarthome.data.model.LoginRequestJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
