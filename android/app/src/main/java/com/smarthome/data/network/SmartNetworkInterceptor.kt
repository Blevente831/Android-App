package com.smarthome.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.smarthome.data.api.ApiConfig
import com.smarthome.ui.components.ConnectionType
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


class SmartNetworkInterceptor(private val context: Context) : Interceptor {

    private var consecutiveFailures = 0
    private val maxFailures = 3

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val isDeviceUpdateRequest = originalRequest.method == "PUT" &&
                originalRequest.url.toString().contains("/devices/")

        if (isDeviceUpdateRequest) {
            return try {
                val response = chain.proceed(originalRequest)

                // Reset failure counter on success
                if (response.isSuccessful) {
                    consecutiveFailures = 0
                    ApiConfig.updateConnectionStatus(true)
                }

                response
            } catch (e: Exception) {
                // For device updates, just propagate the exception
                // No retries or endpoint switching
                throw e
            }
        }


        updateNetworkState()

        val currentBaseUrl = ApiConfig.getCurrentBaseUrl()

        val modifiedRequest = if (originalRequest.url.host.contains("smart-home")) {
            rebuildRequestWithEndpoint(originalRequest, currentBaseUrl)
        } else {
            originalRequest
        }

        return try {
            val response = chain.proceed(modifiedRequest)

            if (response.isSuccessful) {
                consecutiveFailures = 0
                ApiConfig.updateConnectionStatus(true)
            } else if (response.code == 408 || response.code >= 500) {
                handleConnectionFailure()
            }

            response
        } catch (e: Exception) {
            when (e) {
                is SocketTimeoutException, is UnknownHostException, is IOException -> {
                    handleConnectionFailure()
                }
            }


            if (ApiConfig.useAutoNetworkSwitching.value &&
                consecutiveFailures >= maxFailures) {
                val alternativeBaseUrl = getAlternativeEndpoint()

                if (alternativeBaseUrl != currentBaseUrl) {
                    val alternativeRequest = rebuildRequestWithEndpoint(originalRequest, alternativeBaseUrl)
                    try {
                        return chain.proceed(alternativeRequest)
                    } catch (e: Exception) {
                        throw e // If this also fails, we're out of options
                    }
                }
            }

            throw e
        }
    }


    private fun updateNetworkState() {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

        if (networkCapabilities != null) {
            ApiConfig.updateConnectionStatus(true)

            when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    ApiConfig.updateConnectionType(ConnectionType.WIFI)
                }
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    ApiConfig.updateConnectionType(ConnectionType.CELLULAR)
                }
                else -> {
                    ApiConfig.updateConnectionType(ConnectionType.NONE)
                }
            }
        } else {
            ApiConfig.updateConnectionStatus(false)
            ApiConfig.updateConnectionType(ConnectionType.NONE)
        }
    }


    private fun handleConnectionFailure() {
        consecutiveFailures++
        ApiConfig.updateConnectionStatus(false)
    }


    private fun getAlternativeEndpoint(): String {
        return when (ApiConfig.currentConnectionType.value) {
            ConnectionType.WIFI -> ApiConfig.cloudEndpointUrl.value // Switch from WiFi to cloud
            ConnectionType.CELLULAR -> ApiConfig.localEndpointUrl.value // Switch from cellular to local
            ConnectionType.NONE -> ApiConfig.cloudEndpointUrl.value // Default to cloud when unknown
        }
    }


    private fun rebuildRequestWithEndpoint(request: Request, baseUrl: String): Request {
        val originalUrl = request.url

        val path = originalUrl.encodedPath
        val query = originalUrl.encodedQuery

        val newUrlBuilder = StringBuilder(baseUrl)

        if (baseUrl.endsWith("/") && path.startsWith("/")) {
            newUrlBuilder.deleteCharAt(newUrlBuilder.length - 1)
        }

        newUrlBuilder.append(path)

        if (!query.isNullOrEmpty()) {
            newUrlBuilder.append("?").append(query)
        }

        return request.newBuilder()
            .url(newUrlBuilder.toString())
            .build()
    }
}