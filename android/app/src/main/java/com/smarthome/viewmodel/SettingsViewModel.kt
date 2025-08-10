package com.smarthome.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarthome.data.model.UserPreferences
import com.smarthome.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    
    companion object {
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"
    }
    
    val darkModeFlow: Flow<Boolean> = userRepository.getUserPreference(KEY_DARK_MODE, false)
    val notificationsEnabled: Flow<Boolean> = userRepository.getUserPreference(KEY_NOTIFICATIONS_ENABLED, true)
    val username = userRepository.getUsername()
    val email = userRepository.getEmail()
    
    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            userRepository.setUserPreference(KEY_DARK_MODE, enabled)
            
            try {
                val preferences = UserPreferences(darkMode = enabled)
                userRepository.updateUserPreferences(preferences)
            } catch (e: Exception) {
            }
        }
    }
    

    
    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }
}
