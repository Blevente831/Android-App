package com.smarthome.data.api

import com.smarthome.data.model.AuthResponse
import com.smarthome.data.model.Device
import com.smarthome.data.model.DeviceInsights
import com.smarthome.data.model.DeviceRequest
import com.smarthome.data.model.DeviceUpdateRequest
import com.smarthome.data.model.LoginRequest
import com.smarthome.data.model.RegisterRequest
import com.smarthome.data.model.UpdateUserRequest
import com.smarthome.data.model.User
import com.smarthome.data.model.WiFiNetwork
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    // Authentication endpoints
    @POST("api/users/login")
    suspend fun login(@Body loginRequest: LoginRequest): AuthResponse
    
    @POST("api/users/register")
    suspend fun register(@Body registerRequest: RegisterRequest): AuthResponse
    
    // User endpointsS
    @GET("api/users/profile")
    suspend fun getUserProfile(): User
    
    @PUT("api/users/profile")
    suspend fun updateUserProfile(@Body updateRequest: UpdateUserRequest): User
    
    // Device endpoints
    @GET("api/devices")
    suspend fun getDevices(): List<Device>
    
    @GET("api/devices/{id}")
    suspend fun getDevice(@Path("id") id: String): Device
    
    @POST("api/devices")
    suspend fun addDevice(@Body deviceRequest: DeviceRequest): Device
    
    @PUT("api/devices/{id}")
    suspend fun updateDevice(
        @Path("id") id: String,
        @Body updateRequest: DeviceUpdateRequest
    ): Device
    
    @DELETE("api/devices/{id}")
    suspend fun deleteDevice(@Path("id") id: String): Boolean
    
    @GET("api/wifi/scan")
    suspend fun scanWifiNetworks(): List<WiFiNetwork>

    @GET("api/devices/{id}/insights")
    suspend fun getDeviceInsights(@Path("id") id: String): DeviceInsights
}
