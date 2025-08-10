package com.smarthome.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarthome.data.model.Device
import com.smarthome.data.model.DeviceUpdateRequest
import com.smarthome.data.repository.DeviceRepository
import com.smarthome.data.utils.DeviceStateRestoreManager
import com.smarthome.data.utils.SharedToggleStateManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DevicesScreenState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val devices: List<Device> = emptyList()
)
@HiltViewModel
class DevicesViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository,
    private val sharedToggleStateManager: SharedToggleStateManager,
    private val deviceStateRestoreManager: DeviceStateRestoreManager
) : ViewModel() {

    private val _state = MutableStateFlow(DevicesScreenState())
    val state: StateFlow<DevicesScreenState> = _state.asStateFlow()

    init {
        loadDevices()
    }

    fun loadDevices() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, error = null) }

                val devices = deviceRepository.getDevices()


                val synchronizedDevices = deviceStateRestoreManager.synchronizeDeviceStates(devices)

                _state.update {
                    it.copy(
                        isLoading = false,
                        devices = synchronizedDevices
                    )
                }

            } catch (e: Exception) {

                if (_state.value.devices.isNotEmpty()) {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = "Network error but using existing data: ${e.localizedMessage}"
                        )
                    }
                } else {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = "Failed to load devices: ${e.localizedMessage}"
                        )
                    }
                }

                e.printStackTrace()
            }
        }
    }

    fun toggleDevice(deviceId: String, isOn: Boolean) {
        viewModelScope.launch {
            try {

                deviceStateRestoreManager.updateDeviceToggleState(deviceId, isOn)

                _state.update { currentState ->
                    val updatedDevices = currentState.devices.map { device ->
                        if (device.id == deviceId) {
                            device.copy(isOn = isOn)
                        } else {
                            device
                        }
                    }
                    currentState.copy(devices = updatedDevices)
                }

                // Update on the server
                val updateRequest = DeviceUpdateRequest(isOn = isOn)
                deviceRepository.updateDevice(deviceId, updateRequest)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun refreshDevices() {
        loadDevices()
    }
}