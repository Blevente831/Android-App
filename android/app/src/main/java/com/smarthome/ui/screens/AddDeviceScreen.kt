package com.smarthome.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.smarthome.data.model.DeviceCategory
import com.smarthome.ui.components.TopBarWithBack
import com.smarthome.viewmodel.AddDeviceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceScreen(
    onNavigateBack: () -> Unit,
    onSetupWifi: () -> Unit,
    viewModel: AddDeviceViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val deviceCategories = DeviceCategory.values().filter { it != DeviceCategory.OTHER }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(state.currentStep) {
        when (state.currentStep) {
            AddDeviceViewModel.SetupStep.CONNECT_TO_WIFI -> {

                viewModel.moveToNextStep()
            }
            AddDeviceViewModel.SetupStep.SETUP_COMPLETE -> {
                if (!state.isConnecting) {
                    onNavigateBack()
                }
            }
            else -> { /* No action needed */ }
        }
    }

    Scaffold(
        topBar = {
            TopBarWithBack(
                title = when (state.currentStep) {
                    AddDeviceViewModel.SetupStep.SELECT_DEVICE_TYPE -> "Add Device"
                    AddDeviceViewModel.SetupStep.CONFIGURE_DEVICE -> "Configure Device"
                    AddDeviceViewModel.SetupStep.FINALIZE_SETUP -> "Finalizing"
                    AddDeviceViewModel.SetupStep.SETUP_COMPLETE -> "Setup Complete"
                    else -> "Add Device"
                },
                onBackClick = onNavigateBack
                // Using default actions parameter
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Different content based on current step
            when (state.currentStep) {
                AddDeviceViewModel.SetupStep.SELECT_DEVICE_TYPE -> {
                    // Device type selection screen
                    Text(
                        text = "Select Device Type",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    deviceCategories.forEach { category ->
                        DeviceTypeCard(
                            category = category,
                            isSelected = category == state.selectedDeviceType,
                            onClick = { viewModel.selectDeviceType(category) }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { viewModel.moveToNextStep() },
                        enabled = state.selectedDeviceType != null && !state.isConnecting,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (state.isConnecting) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                color = MaterialTheme.colorScheme.onPrimary,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Icon(Icons.Default.ArrowForward, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Continue to Configuration")
                        }
                    }
                }

                AddDeviceViewModel.SetupStep.CONFIGURE_DEVICE -> {
                    Text(
                        text = "Configure Your Device",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    // Device name field
                    OutlinedTextField(
                        value = state.deviceName,
                        onValueChange = { viewModel.updateDeviceName(it) },
                        label = { Text("Device Name") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Device location field
                    OutlinedTextField(
                        value = state.deviceLocation,
                        onValueChange = { viewModel.updateDeviceLocation(it) },
                        label = { Text("Location (e.g. Living Room)") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { viewModel.moveToNextStep() },
                        enabled = state.deviceName.isNotBlank() && state.deviceLocation.isNotBlank(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Complete Setup")
                    }
                }

                AddDeviceViewModel.SetupStep.FINALIZE_SETUP,
                AddDeviceViewModel.SetupStep.SETUP_COMPLETE -> {
                    // Setup completion screen
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (state.isConnecting) {
                                CircularProgressIndicator(modifier = Modifier.size(48.dp))

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = "Finalizing device setup...",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(80.dp),
                                    tint = MaterialTheme.colorScheme.primary
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = "Setup Complete!",
                                    style = MaterialTheme.typography.titleLarge
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Your device has been successfully set up and connected to your smart home network.",
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(modifier = Modifier.height(24.dp))

                                Button(
                                    onClick = onNavigateBack,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Go to Dashboard")
                                }
                            }
                        }
                    }
                }

                else -> {
                    // Fallback content
                    Text("Loading...")
                }
            }

            // Error message display (shown on any screen)
            if (state.error != null) {
                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Text(
                        text = state.error!!,
                        color = MaterialTheme.colorScheme.onErrorContainer,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedButton(
                    onClick = { viewModel.clearError() },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Dismiss")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceTypeCard(
    category: DeviceCategory,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Device type icon
            Icon(
                imageVector = when (category) {
                    DeviceCategory.LIGHT -> Icons.Default.Lightbulb
                    DeviceCategory.THERMOSTAT -> Icons.Default.Thermostat
                    DeviceCategory.SECURITY -> Icons.Default.Security
                    DeviceCategory.ENTERTAINMENT -> Icons.Default.Tv
                    DeviceCategory.APPLIANCE -> Icons.Default.Kitchen
                    else -> Icons.Default.DevicesOther
                },
                contentDescription = null,
                tint = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = category.displayName,
                style = MaterialTheme.typography.titleMedium,
                color = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.weight(1f))

            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Selected",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}