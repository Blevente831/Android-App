package com.smarthome.ui.theme

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.smarthome.ui.theme.ThemeMode
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {
    
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    
    companion object {
        private const val PREFERENCES_NAME = "smart_home_preferences"
        private const val KEY_THEME_MODE = "theme_mode"
        private const val KEY_AUTH_TOKEN = "auth_token"
    }
    
    fun saveAuthToken(token: String) {
        sharedPreferences.edit {
            putString(KEY_AUTH_TOKEN, token)
        }
    }
    
    fun getAuthToken(): String? {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null)
    }
    
    fun clearAuthToken() {
        sharedPreferences.edit {
            remove(KEY_AUTH_TOKEN)
        }
    }
    
    fun saveThemeMode(themeMode: ThemeMode) {
        sharedPreferences.edit {
            putString(KEY_THEME_MODE, themeMode.name)
        }
    }
    
    fun getThemeMode(): ThemeMode {
        val savedThemeMode = sharedPreferences.getString(KEY_THEME_MODE, null)
        return if (savedThemeMode != null) {
            try {
                ThemeMode.valueOf(savedThemeMode)
            } catch (e: IllegalArgumentException) {
                ThemeMode.SYSTEM
            }
        } else {
            ThemeMode.SYSTEM
        }
    }
}