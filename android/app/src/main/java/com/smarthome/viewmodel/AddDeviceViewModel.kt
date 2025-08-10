package com.smarthome.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarthome.data.model.DeviceCategory
import com.smarthome.data.model.DeviceRequest
import com.smarthome.data.model.WiFiNetwork
import com.smarthome.data.repository.DeviceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddDeviceViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository
) : ViewModel() {

    enum class SetupStep {
        SELECT_DEVICE_TYPE,
        CONNECT_TO_WIFI,
        CONFIGURE_DEVICE,
        FINALIZE_SETUP,
        SETUP_COMPLETE
    }

    data class AddDeviceState(
        val currentStep: SetupStep = SetupStep.SELECT_DEVICE_TYPE,
        val selectedDeviceType: DeviceCategory? = null,
        val availableNetworks: List<WiFiNetwork> = emptyList(),
        val isScanning: Boolean = false,
        val selectedNetwork: WiFiNetwork? = null,
        val wifiPassword: String = "",
        val deviceName: String = "",
        val deviceLocation: String = "",
        val isConnecting: Boolean = false,
        val error: String? = null
    )

    private val _state = MutableStateFlow(AddDeviceState())
    val state: StateFlow<AddDeviceState> = _state.asStateFlow()

    fun selectDeviceType(category: DeviceCategory) {
        _state.update { it.copy(selectedDeviceType = category) }
    }

    fun moveToNextStep() {
        val currentStep = _state.value.currentStep
        val nextStep = when (currentStep) {
            SetupStep.SELECT_DEVICE_TYPE -> SetupStep.CONNECT_TO_WIFI
            SetupStep.CONNECT_TO_WIFI -> SetupStep.CONFIGURE_DEVICE
            SetupStep.CONFIGURE_DEVICE -> SetupStep.FINALIZE_SETUP
            SetupStep.FINALIZE_SETUP -> SetupStep.SETUP_COMPLETE
            SetupStep.SETUP_COMPLETE -> SetupStep.SETUP_COMPLETE // Already at the last step
        }

        _state.update { it.copy(currentStep = nextStep) }

        // Simulate device setup completion after a delay
        if (nextStep == SetupStep.FINALIZE_SETUP) {
            _state.update { it.copy(isConnecting = true) }
            completeDeviceSetup()
        }
    }


    fun updateDeviceName(name: String) {
        _state.update { it.copy(deviceName = name) }
    }

    fun updateDeviceLocation(location: String) {
        _state.update { it.copy(deviceLocation = location) }
    }



    private fun completeDeviceSetup() {
        viewModelScope.launch {
            try {
                // Simulate device setup delay
                delay(3000)

                // Get the device category and ensure it matches backend expectations
                val category = _state.value.selectedDeviceType!!


                // Create the device on the backend
                val deviceRequest = DeviceRequest(
                    name = _state.value.deviceName.ifEmpty { "New Device" },
                    category = category,
                    location = _state.value.deviceLocation.ifEmpty { "Home" },
                    properties = mapOf(
                        "firmwareVersion" to "1.0.0",
                        "wifiSSID" to (_state.value.selectedNetwork?.ssid ?: "Home Network"),
                        "isOn" to "false",
                        "brightness" to "0.5"
                    )
                )

                try {
                    val device = deviceRepository.addDevice(deviceRequest)
                    println("Device created successfully: ${device.id}")

                    _state.update {
                        it.copy(
                            currentStep = SetupStep.SETUP_COMPLETE,
                            isConnecting = false
                        )
                    }
                } catch (apiError: Exception) {

                    _state.update {
                        it.copy(
                            error = "Failed to create device: ${apiError.message}",
                            isConnecting = false
                        )
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()

                _state.update {
                    it.copy(
                        error = "Failed to complete setup: ${e.message}",
                        isConnecting = false
                    )
                }
            }
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}
