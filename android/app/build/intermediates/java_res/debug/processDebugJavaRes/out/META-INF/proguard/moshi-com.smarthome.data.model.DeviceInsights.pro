-if class com.smarthome.data.model.DeviceInsights
-keepnames class com.smarthome.data.model.DeviceInsights
-if class com.smarthome.data.model.DeviceInsights
-keep class com.smarthome.data.model.DeviceInsightsJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.smarthome.data.model.DeviceInsights
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.smarthome.data.model.DeviceInsights
-keepclassmembers class com.smarthome.data.model.DeviceInsights {
    public synthetic <init>(boolean,java.lang.String,java.lang.String,com.smarthome.data.model.InsightData,java.lang.String,java.lang.String,java.util.List,java.lang.Float,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
