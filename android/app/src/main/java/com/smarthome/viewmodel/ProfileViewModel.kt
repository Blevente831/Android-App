package com.smarthome.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarthome.data.model.User
import com.smarthome.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val user: User? = null
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.asStateFlow()

    fun loadUserProfile() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, error = null) }
                
                val currentUser = userRepository.getUserProfile()
                
                _state.update { 
                    it.copy(
                        isLoading = false,
                        user = currentUser
                    )
                }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        isLoading = false,
                        error = "Failed to load profile: ${e.localizedMessage}"
                    )
                }
            }
        }
    }
    
    fun signOut() {
        viewModelScope.launch {
            try {
                userRepository.logout()
                // The navigation to login screen will be handled by the caller
            } catch (e: Exception) {
                _state.update { 
                    it.copy(error = "Failed to sign out: ${e.localizedMessage}")
                }
            }
        }
    }
}