package com.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.smarthome.data.utils.DeviceStateManager
import com.smarthome.data.utils.DeviceStateRestoreManager
import com.smarthome.data.utils.SharedToggleStateManager
import com.smarthome.ui.theme.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var deviceStateManager: DeviceStateManager

    @Inject
    lateinit var sharedToggleStateManager: SharedToggleStateManager

    @Inject
    lateinit var deviceStateRestoreManager: DeviceStateRestoreManager

    private lateinit var themeViewModel: ThemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get theme view model
        themeViewModel = ViewModelProvider(this)[ThemeViewModel::class.java]

        // Update current activity reference
        themeViewModel.updateCurrentActivity(this)

        // Restore all device and toggle states from persistent storage
        deviceStateRestoreManager.restoreDeviceStates()

        println("MainActivity onCreate: App initialized with theme ${themeViewModel.state.value.themeMode}")

        setContent {
            SmartHomeApp()
        }
    }

    override fun onResume() {
        super.onResume()

        // Ensure theme is refreshed when coming back to foreground
        themeViewModel.refreshTheme()

        // Refresh device states from persistent storage when activity resumes
        deviceStateRestoreManager.restoreDeviceStates()

        println("MainActivity onResume: App resumed with theme ${themeViewModel.state.value.themeMode}")
    }

    override fun onPause() {
        super.onPause()

        // Ensure any pending state changes are persisted before the app goes to background
        deviceStateRestoreManager.persistDeviceStates()
        println("MainActivity onPause: Device states saved to persistent storage")
    }
}