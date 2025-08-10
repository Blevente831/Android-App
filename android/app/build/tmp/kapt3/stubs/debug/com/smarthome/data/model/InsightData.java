package com.smarthome.data.model;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00b1\u0001\u0010#\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0004H\u00d6\u0001R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010\u00a8\u0006*"}, d2 = {"Lcom/smarthome/data/model/InsightData;", "", "timePatterns", "", "", "dayPatterns", "preferences", "", "automationSuggestions", "energySavingTips", "seasonalAdjustments", "predictiveAutomations", "anomalies", "routines", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnomalies", "()Ljava/util/List;", "getAutomationSuggestions", "getDayPatterns", "getEnergySavingTips", "getPredictiveAutomations", "getPreferences", "()Ljava/util/Map;", "getRoutines", "getSeasonalAdjustments", "getTimePatterns", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class InsightData {
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> timePatterns = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> dayPatterns = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.Map<java.lang.String, java.lang.String> preferences = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> automationSuggestions = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> energySavingTips = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> seasonalAdjustments = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> predictiveAutomations = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> anomalies = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> routines = null;
    
    public InsightData(@com.squareup.moshi.Json(name = "timePatterns")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> timePatterns, @com.squareup.moshi.Json(name = "dayPatterns")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> dayPatterns, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> preferences, @com.squareup.moshi.Json(name = "automationSuggestions")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> automationSuggestions, @com.squareup.moshi.Json(name = "energySavingTips")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> energySavingTips, @com.squareup.moshi.Json(name = "seasonalAdjustments")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> seasonalAdjustments, @com.squareup.moshi.Json(name = "predictiveAutomations")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> predictiveAutomations, @com.squareup.moshi.Json(name = "anomalies")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> anomalies, @com.squareup.moshi.Json(name = "routines")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> routines) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getTimePatterns() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getDayPatterns() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.String> getPreferences() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getAutomationSuggestions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getEnergySavingTips() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getSeasonalAdjustments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getPredictiveAutomations() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getAnomalies() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getRoutines() {
        return null;
    }
    
    public InsightData() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.model.InsightData copy(@com.squareup.moshi.Json(name = "timePatterns")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> timePatterns, @com.squareup.moshi.Json(name = "dayPatterns")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> dayPatterns, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> preferences, @com.squareup.moshi.Json(name = "automationSuggestions")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> automationSuggestions, @com.squareup.moshi.Json(name = "energySavingTips")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> energySavingTips, @com.squareup.moshi.Json(name = "seasonalAdjustments")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> seasonalAdjustments, @com.squareup.moshi.Json(name = "predictiveAutomations")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> predictiveAutomations, @com.squareup.moshi.Json(name = "anomalies")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> anomalies, @com.squareup.moshi.Json(name = "routines")
    @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> routines) {
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