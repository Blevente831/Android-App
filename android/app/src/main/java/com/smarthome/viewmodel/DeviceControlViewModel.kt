package com.smarthome.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarthome.data.model.Device
import com.smarthome.data.model.DeviceInsights
import com.smarthome.data.model.DeviceUpdateRequest
import com.smarthome.data.repository.DeviceRepository
import com.smarthome.data.utils.DeviceStateRestoreManager
import com.smarthome.data.utils.SharedToggleStateManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DeviceControlUiState(
    val device: Device? = null,
    val isLoading: Boolean = true,
    val error: String? = null,
    val hasPendingUpdates: Boolean = false,
    val insights: DeviceInsights? = null,
    val isLoadingInsights: Boolean = false
)
@HiltViewModel
class DeviceControlViewModel @Inject constructor(
    private val deviceId: String,
    private val deviceRepository: DeviceRepository,
    private val deviceStateRestoreManager: DeviceStateRestoreManager,
    private val sharedToggleStateManager: SharedToggleStateManager
) : ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(DeviceControlUiState())
    val uiState: StateFlow<DeviceControlUiState> = _uiState.asStateFlow()

    // Track pending update job
    private var activeUpdateJob: Job? = null

    init {
        println("DeviceControlViewModel init for device: $deviceId")
        loadDevice(false)
    }

    fun loadDevice(forceRefresh: Boolean = false) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, error = null) }

                val device = deviceRepository.getDevice(deviceId)
                if (device != null) {
                    val storedToggleState = deviceStateRestoreManager.getStoredToggleState(device.id)

                    val restoredDevice = if (storedToggleState != null) {
                        device.copy(isOn = storedToggleState)
                    } else {
                        device
                    }

                    println("DeviceControlViewModel: Loaded device - id: ${restoredDevice.id}, name: ${restoredDevice.name}, isOn: ${restoredDevice.isOn}")

                    _uiState.update {
                        it.copy(
                            device = restoredDevice,
                            isLoading = false,
                            error = null
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = "Device not found"
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to load device: ${e.message}"
                    )
                }
            }
        }
    }

    fun toggleDevice(isOn: Boolean) {
        val currentDevice = _uiState.value.device ?: return

        activeUpdateJob?.cancel()


        deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, isOn)


        sharedToggleStateManager.storeToggleState(currentDevice.id, isOn)





        activeUpdateJob = viewModelScope.launch {
            try {
                delay(100)

                // Update on the server
                val updateRequest = DeviceUpdateRequest(isOn = isOn)
                val updatedDevice = deviceRepository.updateDevice(currentDevice.id, updateRequest)

                _uiState.update { it.copy(
                    hasPendingUpdates = false
                )}

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = "Network issue: ${e.message ?: "Could not update device"}",
                        hasPendingUpdates = false
                    )
                }

            }
        }
    }


    fun updateBrightness(brightness: Float) {
        val currentDevice = _uiState.value.device ?: return


        activeUpdateJob?.cancel()

        val currentToggleState = currentDevice.isOn

        val updatedProperties = currentDevice.properties?.toMutableMap() ?: mutableMapOf()
        updatedProperties["brightness"] = brightness.toString()

        val localUpdate = currentDevice.copy(
            brightness = brightness, // Update the device's direct brightness property
            properties = updatedProperties,
            isOn = currentToggleState
        )

        deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
        sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

        _uiState.update {
            it.copy(
                device = localUpdate,
                error = null,
                hasPendingUpdates = true
            )
        }

        deviceRepository.updateLocalDeviceState(localUpdate)

        activeUpdateJob = viewModelScope.launch {
            try {
                val updateRequest = DeviceUpdateRequest(
                    brightness = brightness,
                    properties = updatedProperties,
                    isOn = currentToggleState // Explicitly include current toggle state
                )

                val serverUpdatedDevice = deviceRepository.updateDevice(
                    currentDevice.id,
                    updateRequest
                )


                // Re-apply our local state to the server response (defensive)
                val finalDevice = serverUpdatedDevice.copy(
                    isOn = currentToggleState,
                    brightness = brightness // Force preserve the brightness we just set
                )



                _uiState.update { it.copy(
                    device = finalDevice,
                    error = null,
                    hasPendingUpdates = false
                )}

                deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
                sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = "Network issue: ${e.message ?: "Could not update brightness"}",
                        hasPendingUpdates = false
                    )
                }

            }
        }
    }

    fun updateTemperature(temperature: Float) {
        val currentDevice = _uiState.value.device ?: return


        activeUpdateJob?.cancel()

        val currentToggleState = currentDevice.isOn

        val updatedProperties = currentDevice.properties?.toMutableMap() ?: mutableMapOf()
        updatedProperties["temperature"] = temperature.toString()

        val localUpdate = currentDevice.copy(
            properties = updatedProperties,
            isOn = currentToggleState
        )

        deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
        sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

        _uiState.update {
            it.copy(
                device = localUpdate,
                error = null,
                hasPendingUpdates = true
            )
        }


        activeUpdateJob = viewModelScope.launch {
            try {
                val updateRequest = DeviceUpdateRequest(
                    properties = updatedProperties,
                    isOn = currentToggleState // Explicitly include current toggle state
                )

                val serverUpdatedDevice = deviceRepository.updateDevice(
                    currentDevice.id,
                    updateRequest
                )

                val finalDevice = serverUpdatedDevice.copy(isOn = currentToggleState)

                _uiState.update { it.copy(
                    device = finalDevice,
                    error = null,
                    hasPendingUpdates = false
                )}


                deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
                sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = "Network issue: ${e.message ?: "Could not update temperature"}",
                        hasPendingUpdates = false
                    )
                }

                println("Error updating temperature on server: ${e.message}, keeping UI state")
            }
        }
    }

    fun updateVolume(volume: Float) {
        val currentDevice = _uiState.value.device ?: return
        activeUpdateJob?.cancel()

        val currentToggleState = currentDevice.isOn

        val updatedProperties = currentDevice.properties?.toMutableMap() ?: mutableMapOf()
        updatedProperties["volume"] = volume.toString()

        val localUpdate = currentDevice.copy(
            properties = updatedProperties,
            // Keep the same toggle state
            isOn = currentToggleState
        )

        deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
        sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

        // Immediately update UI state for better user experience
        _uiState.update {
            it.copy(
                device = localUpdate,
                error = null,
                hasPendingUpdates = true
            )
        }

        deviceRepository.updateLocalDeviceState(localUpdate)

        activeUpdateJob = viewModelScope.launch {
            try {
                val updateRequest = DeviceUpdateRequest(
                    properties = updatedProperties,
                    isOn = currentToggleState )

                val serverUpdatedDevice = deviceRepository.updateDevice(
                    currentDevice.id,
                    updateRequest
                )

                val finalDevice = serverUpdatedDevice.copy(isOn = currentToggleState)

                _uiState.update { it.copy(
                    device = finalDevice,
                    error = null,
                    hasPendingUpdates = false
                )}

                deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
                sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = "Network issue: ${e.message ?: "Could not update volume"}",
                        hasPendingUpdates = false
                    )
                }

            }
        }
    }

    fun setTimer(minutes: Int) {
        val currentDevice = _uiState.value.device ?: return


        activeUpdateJob?.cancel()

        val currentToggleState = currentDevice.isOn

        val updatedProperties = currentDevice.properties?.toMutableMap() ?: mutableMapOf()
        updatedProperties["timer_minutes"] = minutes.toString()
        updatedProperties["timer_set_at"] = System.currentTimeMillis().toString()

        val localUpdate = currentDevice.copy(
            properties = updatedProperties,
            isOn = currentToggleState
        )

        deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
        sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

        _uiState.update {
            it.copy(
                device = localUpdate,
                error = null,
                hasPendingUpdates = true
            )
        }

        deviceRepository.updateLocalDeviceState(localUpdate)

        activeUpdateJob = viewModelScope.launch {
            try {
                val updateRequest = DeviceUpdateRequest(
                    properties = updatedProperties,
                    isOn = currentToggleState // Explicitly include current toggle state
                )

                // Send update to server
                val serverUpdatedDevice = deviceRepository.updateDevice(
                    currentDevice.id,
                    updateRequest
                )

                val finalDevice = serverUpdatedDevice.copy(isOn = currentToggleState)

                _uiState.update { it.copy(
                    device = finalDevice,
                    error = null,
                    hasPendingUpdates = false
                )}

                deviceStateRestoreManager.updateDeviceToggleState(currentDevice.id, currentToggleState)
                sharedToggleStateManager.storeToggleState(currentDevice.id, currentToggleState)

            } catch (e: Exception) {
                // Show error but preserve the local device state
                _uiState.update { currentState ->
                    currentState.copy(
                        error = "Network issue: ${e.message ?: "Could not set timer"}",
                        hasPendingUpdates = false
                    )
                }

            }
        }
    }



    fun refresh() {
        loadDevice(true)
    }

    fun refreshInsights() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoadingInsights = true) }

                val currentDevice = _uiState.value.device
                if (currentDevice != null) {
                    val insights = deviceRepository.getDeviceInsights(currentDevice.id)

                    _uiState.update { it.copy(
                        insights = insights,
                        isLoadingInsights = false
                    )}


                } else {
                    _uiState.update { it.copy(
                        error = "Cannot load insights: Device not found",
                        isLoadingInsights = false
                    )}
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(
                    error = "Failed to load insights: ${e.message}",
                    isLoadingInsights = false
                )}
            }
        }
    }

    fun deleteDevice(onComplete: (Boolean) -> Unit = {}) {
        viewModelScope.launch {
            try {
                deviceRepository.deleteDevice(deviceId)
                onComplete(true)
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        error = "Failed to delete device: ${e.message}"
                    )
                }
                onComplete(false)
            }
        }
    }

    override fun onCleared() {
        activeUpdateJob?.cancel()
        super.onCleared()
    }
}