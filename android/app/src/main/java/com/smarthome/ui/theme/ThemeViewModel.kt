package com.smarthome.ui.theme

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

enum class ThemeMode {
    LIGHT, DARK, SYSTEM
}

data class ThemeState(
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val pendingThemeChange: Boolean = false
)


@Singleton
class ThemeEventBus @Inject constructor() {
    private val listeners = mutableListOf<() -> Unit>()

    fun registerListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: () -> Unit) {
        listeners.remove(listener)
    }

    fun notifyThemeChanged() {
        listeners.forEach { it.invoke() }
    }
}

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager,
    internal val themeEventBus: ThemeEventBus
) : ViewModel() {

    private val _state = MutableStateFlow(ThemeState())
    val state: StateFlow<ThemeState> = _state.asStateFlow()

    private var currentActivity: Activity? = null

    init {
        loadThemeSettings()
    }

    private fun loadThemeSettings() {
        viewModelScope.launch {
            val savedThemeMode = preferencesManager.getThemeMode()
            _state.update { it.copy(themeMode = savedThemeMode) }
        }
    }


    fun updateCurrentActivity(activity: Activity) {
        currentActivity = activity
    }


    fun setThemeMode(themeMode: ThemeMode, activity: Activity? = null) {
        viewModelScope.launch {
            if (themeMode == _state.value.themeMode) {
                return@launch // No change needed
            }

            preferencesManager.saveThemeMode(themeMode)

            _state.update { it.copy(themeMode = themeMode) }

            themeEventBus.notifyThemeChanged()

            val activityToRecreate = activity ?: currentActivity

            println("Applying theme change to: ${themeMode.name}")
            activityToRecreate?.recreate()
        }
    }


    fun refreshTheme() {
        viewModelScope.launch {
            val savedThemeMode = preferencesManager.getThemeMode()
            if (savedThemeMode != _state.value.themeMode) {
                _state.update { it.copy(themeMode = savedThemeMode) }
                themeEventBus.notifyThemeChanged()
            }
        }
    }
}