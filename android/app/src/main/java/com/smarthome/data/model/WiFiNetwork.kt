package com.smarthome.data.model

import com.squareup.moshi.JsonClass


//@JsonClass(generateAdapter = true)
data class WiFiNetwork(
    val ssid: String,
    val bssid: String? = null,
    val isSecured: Boolean = true,
    val signalStrength: Int = -70, // in dBm, higher (closer to 0) is better
    val capabilities: String? = null
) {

}