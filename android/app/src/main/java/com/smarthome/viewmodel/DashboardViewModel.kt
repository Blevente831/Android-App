package com.smarthome.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarthome.data.model.Device
import com.smarthome.data.repository.DeviceRepository
import com.smarthome.data.repository.UserRepository
import com.smarthome.ui.components.ConnectionStatus
import com.smarthome.ui.components.ConnectionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DeviceStats(
    val totalDevices: Int = 0,
    val activeDevices: Int = 0,
    val categories: Map<String, Int> = emptyMap()
)

data class DashboardState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val userName: String = "User",
    val connectionStatus: ConnectionStatus = ConnectionStatus.CONNECTED,
    val connectionType: ConnectionType = ConnectionType.WIFI,
    val deviceStats: DeviceStats = DeviceStats(),
    val favoriteDevices: List<Device> = emptyList()
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state.asStateFlow()


    fun loadDashboard() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, error = null) }
                val currentUser = userRepository.getUserProfile()
                if (currentUser != null) {
                    _state.update { it.copy(userName = currentUser.username) }
                }
                val devices = deviceRepository.getDevices()
                val stats = calculateDeviceStats(devices)
                val activeDevices = devices.filter { it.isOn }.take(5)

                _state.update {
                    it.copy(
                        isLoading = false,
                        deviceStats = stats,
                        favoriteDevices = activeDevices,
                        connectionStatus = ConnectionStatus.CONNECTED,
                        connectionType = ConnectionType.WIFI
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to load dashboard: ${e.localizedMessage}"
                    )
                }
            }
        }
    }

    private fun calculateDeviceStats(devices: List<Device>): DeviceStats {
        val totalDevices = devices.size
        val activeDevices = devices.count { it.isOn }
        val categories = devices
            .groupBy { it.category.displayName }
            .mapValues { it.value.size }
        return DeviceStats(
            totalDevices = totalDevices,
            activeDevices = activeDevices,
            categories = categories
        )
    }
}