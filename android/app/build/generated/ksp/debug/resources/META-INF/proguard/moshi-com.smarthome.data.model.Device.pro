-if class com.smarthome.data.model.Device
-keepnames class com.smarthome.data.model.Device
-if class com.smarthome.data.model.Device
-keep class com.smarthome.data.model.DeviceJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.smarthome.data.model.Device
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.smarthome.data.model.Device
-keepclassmembers class com.smarthome.data.model.Device {
    public synthetic <init>(java.lang.String,java.lang.String,com.smarthome.data.model.DeviceCategory,java.lang.String,boolean,float,java.util.Map,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
