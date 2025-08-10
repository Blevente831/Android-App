package com.smarthome.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    val username: String,
    val email: String,
    @Json(name = "created_at") val createdAt: String? = null,
    val preferences: UserPreferences? = null
)

@JsonClass(generateAdapter = true)
data class UserPreferences(
    @Json(name = "dark_mode") val darkMode: Boolean = false,
    @Json(name = "notifications_enabled") val notificationsEnabled: Boolean = true,
    @Json(name = "temperature_unit") val temperatureUnit: TemperatureUnit = TemperatureUnit.FAHRENHEIT,
    @Json(name = "auto_discovery") val autoDiscovery: Boolean = true
)

enum class TemperatureUnit {
    @Json(name = "celsius") CELSIUS,
    @Json(name = "fahrenheit") FAHRENHEIT
}

@JsonClass(generateAdapter = true)
data class LoginRequest(
    val email: String,
    val password: String
)



@JsonClass(generateAdapter = true)
data class AuthResponse(
    val token: String,
    val user: User
)

@JsonClass(generateAdapter = true)
data class UpdateUserRequest(
    val username: String? = null,
    @Json(name = "first_name") val firstName: String? = null,
    @Json(name = "last_name") val lastName: String? = null,
    val preferences: UserPreferences? = null
)
