package com.smarthome.data.repository

import android.content.SharedPreferences
import com.smarthome.data.api.ApiService
import com.smarthome.data.model.AuthResponse
import com.smarthome.data.model.LoginRequest
import com.smarthome.data.model.RegisterRequest
import com.smarthome.data.model.UpdateUserRequest
import com.smarthome.data.model.User
import com.smarthome.data.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface UserRepository {
    suspend fun login(email: String, password: String): AuthResponse
    suspend fun register(registerRequest: RegisterRequest): AuthResponse
    suspend fun getUserProfile(): User
    suspend fun updateUserProfile(updateRequest: UpdateUserRequest): User
    suspend fun logout()
    suspend fun updateUserPreferences(preferences: UserPreferences): User
    
    fun getUserPreference(key: String, defaultValue: Boolean): Flow<Boolean>
    suspend fun setUserPreference(key: String, value: Boolean)
    
    fun getUsername(): Flow<String>
    fun getEmail(): Flow<String>
    fun isUserLoggedIn(): Boolean
    fun getAuthToken(): String?
}

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val sharedPreferences: SharedPreferences
) : UserRepository {
    
    companion object {
        private const val KEY_AUTH_TOKEN = "auth_token"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_USER_EMAIL = "user_email"
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"
    }
    
    override suspend fun login(email: String, password: String): AuthResponse {
        val loginRequest = LoginRequest(email, password)
        val response = apiService.login(loginRequest)
        
        // Save auth token and user info
        with(sharedPreferences.edit()) {
            putString(KEY_AUTH_TOKEN, response.token)
            putString(KEY_USER_NAME, response.user.username)
            putString(KEY_USER_EMAIL, response.user.email)
            
            // Save user preferences
            response.user.preferences?.let { prefs ->
                putBoolean(KEY_DARK_MODE, prefs.darkMode)
                putBoolean(KEY_NOTIFICATIONS_ENABLED, prefs.notificationsEnabled)
            }
            
            apply()
        }
        
        return response
    }
    
    override suspend fun register(registerRequest: RegisterRequest): AuthResponse {
        val response = apiService.register(registerRequest)
        
        // Save auth token and user info
        with(sharedPreferences.edit()) {
            putString(KEY_AUTH_TOKEN, response.token)
            putString(KEY_USER_NAME, response.user.username)
            putString(KEY_USER_EMAIL, response.user.email)
            apply()
        }
        
        return response
    }
    
    override suspend fun getUserProfile(): User {
        return apiService.getUserProfile()
    }
    
    override suspend fun updateUserProfile(updateRequest: UpdateUserRequest): User {
        val user = apiService.updateUserProfile(updateRequest)
        
        with(sharedPreferences.edit()) {
            updateRequest.username?.let { putString(KEY_USER_NAME, it) }
            
            updateRequest.preferences?.let { prefs ->
                putBoolean(KEY_DARK_MODE, prefs.darkMode)
                putBoolean(KEY_NOTIFICATIONS_ENABLED, prefs.notificationsEnabled)
            }
            
            apply()
        }
        
        return user
    }
    
    override suspend fun logout() {
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
    }
    
    override suspend fun updateUserPreferences(preferences: UserPreferences): User {
        val updateRequest = UpdateUserRequest(preferences = preferences)
        return updateUserProfile(updateRequest)
    }
    
    override fun getUserPreference(key: String, defaultValue: Boolean): Flow<Boolean> = flow {
        emit(sharedPreferences.getBoolean(key, defaultValue))
    }
    
    override suspend fun setUserPreference(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
    
    override fun getUsername(): Flow<String> = flow {
        emit(sharedPreferences.getString(KEY_USER_NAME, "User") ?: "User")
    }
    
    override fun getEmail(): Flow<String> = flow {
        emit(sharedPreferences.getString(KEY_USER_EMAIL, "") ?: "")
    }
    
    override fun isUserLoggedIn(): Boolean {
        return !getAuthToken().isNullOrEmpty()
    }
    
    override fun getAuthToken(): String? {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null)
    }
}
