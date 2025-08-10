package com.smarthome.data.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.smarthome.data.model.Device
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DeviceStateManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val deviceStates = mutableMapOf<String, Device>()

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    private val gson = Gson()

    init {
        loadFromPersistentStorage()
    }


    fun getAllDevices(): List<Device> {
        return deviceStates.values.toList()
    }


    fun getDeviceState(deviceId: String): Device? {
        return deviceStates[deviceId]
    }


    fun updateDeviceState(device: Device) {

        deviceStates[device.id] = device

        saveToPersistentStorage()
    }


    fun updateDeviceProperties(
        deviceId: String,
        isOn: Boolean? = null,
        brightness: Float? = null,
        properties: Map<String, String>? = null
    ): Device? {
        val device = deviceStates[deviceId] ?: return null

        val updatedDevice = device.copy(
            isOn = isOn ?: device.isOn,
            brightness = brightness ?: device.brightness,
            properties = properties ?: device.properties
        )

        deviceStates[deviceId] = updatedDevice

        // Update persistent storage
        saveToPersistentStorage()

        return updatedDevice
    }


    fun clearDeviceState(deviceId: String) {
        deviceStates.remove(deviceId)
        saveToPersistentStorage()
    }


    fun clearAllDeviceStates() {
        deviceStates.clear()
        preferences.edit().remove(KEY_DEVICE_STATES).apply()
    }


    fun getDeviceCount(): Int {
        return deviceStates.size
    }


    fun refreshFromPersistentStorage() {
        loadFromPersistentStorage()
    }


    private fun saveToPersistentStorage() {
        try {
            val deviceListJson = gson.toJson(deviceStates.values.toList())
            preferences.edit().putString(KEY_DEVICE_STATES, deviceListJson).apply()
        } catch (e: Exception) {
            // Log error but continue - memory cache will still work
        }
    }


    private fun loadFromPersistentStorage() {
        try {
            val deviceListJson = preferences.getString(KEY_DEVICE_STATES, null)
            if (!deviceListJson.isNullOrEmpty()) {
                val type = object : TypeToken<List<Device>>() {}.type
                val devices: List<Device> = gson.fromJson(deviceListJson, type)

                // Clear current memory cache and reload
                deviceStates.clear()
                devices.forEach { device ->
                    deviceStates[device.id] = device
                }
            }
        } catch (e: Exception) {

        }
    }

    companion object {
        private const val PREFS_NAME = "smart_home_device_states"
        private const val KEY_DEVICE_STATES = "device_states"
    }
}