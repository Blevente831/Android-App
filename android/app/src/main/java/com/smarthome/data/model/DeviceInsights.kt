package com.smarthome.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeviceInsights(
    val available: Boolean,
    val deviceId: String? = null,
    val message: String? = null,
    val insights: InsightData? = null,
    val analysisTimestamp: String? = null,
    val error: String? = null,
    @Json(name = "suggestedAutomations") val suggestedAutomations: List<String>? = null,
    val confidenceScore: Float? = null
)

@JsonClass(generateAdapter = true)
data class InsightData(
    @Json(name = "timePatterns") val timePatterns: List<String>? = null,
    @Json(name = "dayPatterns") val dayPatterns: List<String>? = null,
    val preferences: Map<String, String>? = null,
    @Json(name = "automationSuggestions") val automationSuggestions: List<String>? = null,
    @Json(name = "energySavingTips") val energySavingTips: List<String>? = null,

    // Advanced ML prediction fields
    @Json(name = "seasonalAdjustments") val seasonalAdjustments: List<String>? = null,
    @Json(name = "predictiveAutomations") val predictiveAutomations: List<String>? = null,
    @Json(name = "anomalies") val anomalies: List<String>? = null,
    @Json(name = "routines") val routines: List<String>? = null

)