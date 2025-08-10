package com.smarthome.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class Device(
    val id: String,
    val name: String,
    val category: DeviceCategory,
    val location: String,
    val isOn: Boolean = false,

    val brightness: Float = 0.5f,
    val properties: Map<String, String>? = null
) : Serializable


enum class DeviceCategory(val displayName: String) : Serializable {
    @Json(name = "light") LIGHT("Light"),
    @Json(name = "thermostat") THERMOSTAT("Thermostat"),
    @Json(name = "security") SECURITY("Security"),
    @Json(name = "entertainment") ENTERTAINMENT("Entertainment"),
    @Json(name = "appliance") APPLIANCE("Appliance"),
    @Json(name = "speaker") SPEAKER("Speaker"),
    @Json(name = "other") OTHER("Other");

    companion object {
        fun fromString(value: String): DeviceCategory {
            return values().find { it.name.equals(value, ignoreCase = true) ||
                    it.displayName.equals(value, ignoreCase = true) } ?: OTHER
        }
    }
}
data class DeviceRequest(
    val name: String,
    val category: DeviceCategory,
    val location: String,
    val properties: Map<String, String>? = null
)

data class DeviceUpdateRequest(
    val name: String? = null,
    val location: String? = null,
    val isOn: Boolean? = null,
    val brightness: Float? = null,
    val properties: Map<String, String>? = null
)

