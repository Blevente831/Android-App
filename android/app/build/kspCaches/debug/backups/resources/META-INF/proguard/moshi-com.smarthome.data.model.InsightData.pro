-if class com.smarthome.data.model.InsightData
-keepnames class com.smarthome.data.model.InsightData
-if class com.smarthome.data.model.InsightData
-keep class com.smarthome.data.model.InsightDataJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.smarthome.data.model.InsightData
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.smarthome.data.model.InsightData
-keepclassmembers class com.smarthome.data.model.InsightData {
    public synthetic <init>(java.util.List,java.util.List,java.util.Map,java.util.List,java.util.List,java.util.List,java.util.List,java.util.List,java.util.List,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
