package com.smarthome.data.repository

import com.smarthome.data.api.ApiService
import com.smarthome.data.model.Device
import com.smarthome.data.model.DeviceInsights
import com.smarthome.data.model.DeviceRequest
import com.smarthome.data.model.DeviceUpdateRequest
import com.smarthome.data.model.InsightData
import com.smarthome.data.model.WiFiNetwork
import com.smarthome.data.utils.DeviceStateManager
import com.smarthome.data.utils.NetworkErrorHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.SocketTimeoutException
import javax.inject.Inject

interface DeviceRepository {
    suspend fun getDevices(): List<Device>
    suspend fun getAllDevices(): List<Device> // Add this method for dashboard
    suspend fun getDevice(id: String): Device
    suspend fun addDevice(deviceRequest: DeviceRequest): Device
    suspend fun updateDevice(id: String, updateRequest: DeviceUpdateRequest): Device
    suspend fun deleteDevice(id: String): Boolean
    suspend fun scanWifiNetworks(): List<WiFiNetwork>
    suspend fun getDeviceInsights(id: String): DeviceInsights

    // Local state management methods
    fun getCachedDeviceState(id: String): Device?
    fun updateLocalDeviceState(device: Device)
}

class DeviceRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val deviceStateManager: DeviceStateManager,
    private val networkErrorHandler: NetworkErrorHandler
) : DeviceRepository {

    override suspend fun getDevices(): List<Device> {
        try {
            val devices = apiService.getDevices()
            devices.forEach { deviceStateManager.updateDeviceState(it) }
            return devices
        } catch (e: Exception) {
            val errorMessage = networkErrorHandler.getErrorMessage(e)
            println("Failed to fetch devices: $errorMessage")

            if (networkErrorHandler.shouldRetry(e)) {
                delay(networkErrorHandler.getRetryDelay(0))
                try {
                    // Retry the request
                    val devices = apiService.getDevices()
                    devices.forEach { deviceStateManager.updateDeviceState(it) }
                    return devices
                } catch (retryException: Exception) {
                    // If retry fails, check if we have any cached devices
                    val cachedDevices = deviceStateManager.getAllDevices()
                    if (cachedDevices.isNotEmpty()) {
                        return cachedDevices
                    }
                    // If no cached devices either, rethrow the exception
                    throw retryException
                }
            }

            val cachedDevices = deviceStateManager.getAllDevices()
            if (cachedDevices.isNotEmpty()) {
                return cachedDevices
            }

            throw e
        }
    }

    override suspend fun getAllDevices(): List<Device> {
        return getDevices()
    }

    override suspend fun getDevice(id: String): Device {
        try {
            val device = apiService.getDevice(id)
            deviceStateManager.updateDeviceState(device)
            return device
        } catch (e: Exception) {
            return deviceStateManager.getDeviceState(id) ?: throw e
        }
    }

    override suspend fun addDevice(deviceRequest: DeviceRequest): Device {
        val newDevice = apiService.addDevice(deviceRequest)
        return newDevice
    }

    override suspend fun updateDevice(id: String, updateRequest: DeviceUpdateRequest): Device {
        val currentDevice = deviceStateManager.getDeviceState(id)


        if (currentDevice != null) {
            val localUpdate = currentDevice.copy(
                isOn = updateRequest.isOn ?: currentDevice.isOn,
                brightness = updateRequest.brightness ?: currentDevice.brightness,
                name = updateRequest.name ?: currentDevice.name,
                location = updateRequest.location ?: currentDevice.location,
                properties = updateRequest.properties ?: currentDevice.properties
            )
            deviceStateManager.updateDeviceState(localUpdate)

        }

        val maxRetries = networkErrorHandler.getMaxRetryAttempts(NetworkErrorHandler.OperationType.UPDATE)

        var attemptCount = 0
        var lastException: Exception? = null

        while (attemptCount <= maxRetries) {
            try {
                // Add some delay before retries (not before first attempt)
                if (attemptCount > 0) {
                    val retryDelay = networkErrorHandler.getRetryDelay(attemptCount - 1)
                    delay(retryDelay)
                }

                // Make API call
                val updatedDevice = apiService.updateDevice(id, updateRequest)

                // Update both in-memory and persistent storage with server response
                deviceStateManager.updateDeviceState(updatedDevice)


                // Return the server-updated device
                return updatedDevice
            } catch (e: Exception) {
                lastException = e

                // Decide whether to retry based on the exception type
                if (!networkErrorHandler.shouldRetry(e) || attemptCount >= maxRetries) {
                    // We either shouldn't retry this type of error or we've reached max retries
                    break
                }
            }

            attemptCount++
        }

        deviceStateManager.getDeviceState(id)?.let {
            return it
        }

        throw lastException ?: IllegalStateException("Failed to update device and no cached state available")
    }

    override suspend fun deleteDevice(id: String): Boolean {
        val result = apiService.deleteDevice(id)
        if (result) {
            // Remove from cache if successfully deleted
            deviceStateManager.clearDeviceState(id)
        }
        return result
    }

    override suspend fun scanWifiNetworks(): List<WiFiNetwork> {

        return apiService.scanWifiNetworks()
    }

    override suspend fun getDeviceInsights(id: String): DeviceInsights {

        val maxRetries = networkErrorHandler.getMaxRetryAttempts(NetworkErrorHandler.OperationType.AI_OPERATION)

        var attemptCount = 0
        var lastException: Exception? = null

        while (attemptCount <= maxRetries) {
            try {
                if (attemptCount > 0) {
                    val retryDelay = networkErrorHandler.getRetryDelay(attemptCount - 1)
                    delay(retryDelay)
                }

                val insights = apiService.getDeviceInsights(id)


                return insights
            } catch (e: Exception) {
                lastException = e


                if (!networkErrorHandler.shouldRetry(e) || attemptCount >= maxRetries) {
                    break
                }
            }

            attemptCount++
        }

        val cachedDevice = deviceStateManager.getDeviceState(id)
        if (cachedDevice != null) {

            val errorMessage = if (lastException is SocketTimeoutException) {
                "AI insights temporarily unavailable - the operation timed out. Please try again later."
            } else {
                "AI insights temporarily unavailable. Please check your connection and try again."
            }


            return DeviceInsights(
                available = false,  // Mark as not available
                deviceId = id,
                message = errorMessage,
                insights = null,    // No insights available
                suggestedAutomations = emptyList() // No suggestions available
            )
        }

        // No cached device information available, have to throw the exception
        throw lastException ?: IllegalStateException("Failed to get device insights and no cached data available")
    }



    // Local state management implementations
    override fun getCachedDeviceState(id: String): Device? {
        return deviceStateManager.getDeviceState(id)
    }

    override fun updateLocalDeviceState(device: Device) {
        deviceStateManager.updateDeviceState(device)
    }
}
