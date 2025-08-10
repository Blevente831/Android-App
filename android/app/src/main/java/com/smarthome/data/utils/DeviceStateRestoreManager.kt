package com.smarthome.data.utils

import android.content.Context
import android.content.SharedPreferences
import com.smarthome.data.model.Device
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceStateRestoreManager @Inject constructor(
    private val context: Context,
    private val deviceStateManager: DeviceStateManager,
    private val sharedToggleStateManager: SharedToggleStateManager
) {
    // SharedPreferences key for storage
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("device_state_restore_prefs", Context.MODE_PRIVATE)
    }

    // Constants for preference keys
    companion object {
        private const val KEY_PREFIX_DEVICE_STATE = "device_state_"
        private const val KEY_PREFIX_LAST_REFRESH = "last_refresh_"
    }

    fun updateDeviceToggleState(deviceId: String, isOn: Boolean) {
        sharedToggleStateManager.storeToggleState(deviceId, isOn)

        sharedPreferences.edit().apply {
            putBoolean("$KEY_PREFIX_DEVICE_STATE$deviceId", isOn)
            apply()
        }
    }


    fun restoreAllDeviceToggleStates() {
        val allPrefs = sharedPreferences.all

        allPrefs.forEach { (key, value) ->
            if (key.startsWith(KEY_PREFIX_DEVICE_STATE) && value is Boolean) {
                val deviceId = key.removePrefix(KEY_PREFIX_DEVICE_STATE)
                // Restore to in-memory toggle state manager
                sharedToggleStateManager.storeToggleState(deviceId, value)
            }
        }
    }


    fun restoreDeviceStates() {
        // First restore toggle states
        restoreAllDeviceToggleStates()

        // Also refresh the shared toggle state manager from its persistent storage
        sharedToggleStateManager.refreshFromPersistentStorage()

    }


    fun synchronizeDeviceStates(devices: List<Device>): List<Device> {
        return devices.map { device ->
            val storedToggleState = getStoredToggleState(device.id)
            if (storedToggleState != null && storedToggleState != device.isOn) {

                val synchronizedDevice = device.copy(isOn = storedToggleState)

                deviceStateManager.updateDeviceState(synchronizedDevice)

                synchronizedDevice
            } else {
                device
            }
        }
    }

    fun getStoredToggleState(deviceId: String): Boolean? {
        // First check the in-memory state
        val memoryState = sharedToggleStateManager.getToggleState(deviceId)
        if (memoryState != null) {
            return memoryState
        }

        // If not in memory, check SharedPreferences
        if (sharedPreferences.contains("$KEY_PREFIX_DEVICE_STATE$deviceId")) {
            return sharedPreferences.getBoolean("$KEY_PREFIX_DEVICE_STATE$deviceId", false)
        }

        // No stored state found
        return null
    }


    fun clearDeviceState(deviceId: String) {
        // Clear from SharedToggleStateManager
        sharedToggleStateManager.clearToggleState(deviceId)

        // Clear from SharedPreferences
        sharedPreferences.edit().apply {
            remove("$KEY_PREFIX_DEVICE_STATE$deviceId")
            remove("$KEY_PREFIX_LAST_REFRESH$deviceId")
            apply()
        }

        // Clear from DeviceStateManager
        deviceStateManager.clearDeviceState(deviceId)
    }


    fun persistDeviceStates() {
        // Force sharing the toggle states to persist to SharedPreferences
        val cachedDevices = deviceStateManager.getAllDevices()

        // For each cached device, ensure its toggle state is persisted
        cachedDevices.forEach { device ->
            val toggleState = sharedToggleStateManager.getToggleState(device.id) ?: device.isOn
            updateDeviceToggleState(device.id, toggleState)
        }

        println("Persisted states for ${cachedDevices.size} devices")
    }
}