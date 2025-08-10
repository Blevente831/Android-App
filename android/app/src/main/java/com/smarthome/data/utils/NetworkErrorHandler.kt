package com.smarthome.data.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NetworkErrorHandler @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }


    fun getErrorMessage(e: Exception): String {
        return when (e) {
            is UnknownHostException -> "Cannot connect to server. Check your internet connection."
            is SocketTimeoutException -> "Connection timed out. Server may be unavailable."
            is IOException -> {
                // Check for common connection reset errors
                val message = e.message ?: ""
                when {
                    message.contains("ECONNRESET", ignoreCase = true) ->
                        "Connection was reset. The server might be temporarily unavailable."
                    message.contains("ECONNREFUSED", ignoreCase = true) ->
                        "Connection was refused. The server might be down or unreachable."
                    message.contains("ECONNABORTED", ignoreCase = true) ->
                        "Connection was aborted. Network may be unstable."
                    else -> "Network error: ${e.message ?: "Unknown IO error"}"
                }
            }
            is HttpException -> {
                when (e.code()) {
                    401 -> "Authentication failed. Please login again."
                    403 -> "You don't have permission to access this resource."
                    404 -> "The requested resource was not found."
                    500, 501, 502, 503 -> "Server error. Please try again later."
                    else -> "HTTP Error: ${e.code()}"
                }
            }
            else -> e.message ?: "An unknown error occurred"
        }
    }


    fun shouldRetry(e: Exception): Boolean {
        return when (e) {
            is SocketTimeoutException -> true
            is IOException -> {
                // Always retry connection reset errors as they're typically transient
                val message = e.message ?: ""
                val isConnectionReset = message.contains("ECONNRESET", ignoreCase = true) ||
                        message.contains("ECONNABORTED", ignoreCase = true) ||
                        message.contains("Connection reset", ignoreCase = true)

                if (isConnectionReset) {
                    true
                } else {
                    // For other IO errors, only retry if network is available
                    isNetworkAvailable()
                }
            }
            is HttpException -> {
                val code = e.code()
                code in 500..599
            }
            else -> false
        }
    }


    fun getRetryDelay(attemptCount: Int): Long {
        val baseDelay = 1000L * (1 shl attemptCount)


        val jitter = (baseDelay * 0.25 * Math.random()).toLong()

        return minOf(baseDelay + jitter, 20_000L)
    }


    fun getMaxRetryAttempts(operationType: OperationType): Int {
        return when (operationType) {
            OperationType.FETCH -> 3
            OperationType.UPDATE -> 2
            OperationType.DELETE -> 1
            OperationType.AI_OPERATION -> 5
        }
    }


    enum class OperationType {
        FETCH,         // GET operations
        UPDATE,        // PUT/POST operations
        DELETE,        // DELETE operations
        AI_OPERATION   // AI-related operations that take longer to process
    }
}