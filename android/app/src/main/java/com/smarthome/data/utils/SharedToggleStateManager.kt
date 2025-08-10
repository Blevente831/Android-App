package com.smarthome.data.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedToggleStateManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val deviceToggleStates = mutableMapOf<String, Boolean>()

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    private val gson = Gson()

    init {
        loadFromPersistentStorage()
    }


    fun storeToggleState(deviceId: String, isOn: Boolean) {
        deviceToggleStates[deviceId] = isOn
        saveToPersistentStorage()
    }


    fun getToggleState(deviceId: String): Boolean? {
        return deviceToggleStates[deviceId]
    }


    fun <T> applyToggleStates(devices: List<T>, getId: (T) -> String, updateToggle: (T, Boolean) -> T): List<T> {
        return devices.map { device ->
            val deviceId = getId(device)
            val storedToggleState = deviceToggleStates[deviceId]

            if (storedToggleState != null) {
                updateToggle(device, storedToggleState)
            } else {
                device
            }
        }
    }


    fun clearAllToggleStates() {
        deviceToggleStates.clear()
        preferences.edit().remove(KEY_TOGGLE_STATES).apply()
    }


    fun clearToggleState(deviceId: String) {
        deviceToggleStates.remove(deviceId)
        saveToPersistentStorage()
    }


    fun count(): Int {
        return deviceToggleStates.size
    }


    fun refreshFromPersistentStorage() {
        loadFromPersistentStorage()
    }


    private fun saveToPersistentStorage() {
        try {
            val toggleStatesJson = gson.toJson(deviceToggleStates)
            preferences.edit().putString(KEY_TOGGLE_STATES, toggleStatesJson).apply()
        } catch (e: Exception) {
            // Log error but continue - memory cache will still work
        }
    }


    private fun loadFromPersistentStorage() {
        try {
            val toggleStatesJson = preferences.getString(KEY_TOGGLE_STATES, null)
            if (!toggleStatesJson.isNullOrEmpty()) {
                val type = object : TypeToken<Map<String, Boolean>>() {}.type
                val storedStates: Map<String, Boolean> = gson.fromJson(toggleStatesJson, type)

                // Clear current memory cache and reload
                deviceToggleStates.clear()
                deviceToggleStates.putAll(storedStates)
            }
        } catch (e: Exception) {
            // Log error but continue - will start with empty cache
        }
    }

    companion object {
        private const val PREFS_NAME = "smart_home_toggle_states"
        private const val KEY_TOGGLE_STATES = "toggle_states"
    }
}