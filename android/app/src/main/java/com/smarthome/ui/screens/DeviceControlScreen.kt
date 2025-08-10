package com.smarthome.ui.screens
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Power
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dagger.hilt.android.EntryPointAccessors
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.smarthome.data.model.Device
import com.smarthome.data.model.DeviceCategory
import com.smarthome.data.model.DeviceInsights
import com.smarthome.ui.components.AnimatedLoading
import com.smarthome.ui.theme.light_color
import com.smarthome.ui.theme.security_alert
import com.smarthome.ui.theme.security_safe
import com.smarthome.ui.theme.temperature_cold
import com.smarthome.ui.theme.temperature_warm
import com.smarthome.viewmodel.DeviceControlViewModel
import kotlinx.coroutines.launch
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun DeviceControlScreen(
    deviceId:String,
    navController: NavController,
    // viewModel: DeviceControlViewModel = hiltViewModel()

) {
    val viewModel: DeviceControlViewModel = hiltViewModel()

    val uiState by viewModel.uiState.collectAsState()
    var showDeleteDialog by remember { mutableStateOf(false) }
    var showAutomationDialog by remember { mutableStateOf(false) }
    var selectedAutomation by remember { mutableStateOf("") }

    val deviceId = uiState.device?.id
    val deviceToggleState = remember(deviceId) {
        mutableStateOf(uiState.device?.isOn ?: false)
    }


    LaunchedEffect(deviceId) {
        uiState.device?.isOn?.let { isOn ->
            deviceToggleState.value = isOn
            println("DeviceControlScreen: Initial toggle state for device $deviceId set to $isOn")
        }
    }


    suspend fun handleToggleChange(newState: Boolean) {
        println("DeviceControlScreen: Toggle changing to $newState (current local state: ${deviceToggleState.value})")

        deviceToggleState.value = newState

       viewModel.toggleDevice(newState)

        println("DeviceControlScreen: Local toggle state updated to $newState")
    }

    LaunchedEffect(uiState.device) {
        val device = uiState.device
        if (device != null) {
            println("DeviceControlScreen: Device update received - id: ${device.id}, name: ${device.name}, isOn: ${device.isOn}")
            println("DeviceControlScreen: Our local toggle state is: ${deviceToggleState.value}")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(uiState.device?.name ?: "Device") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Implement edit device */ }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit"
                        )
                    }
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Loading state
            AnimatedVisibility(
                visible = uiState.isLoading,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedLoading()
                }
            }

            // Error state
            AnimatedVisibility(
                visible = uiState.error != null && !uiState.isLoading,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Error loading device",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.error
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = uiState.error ?: "Unknown error",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = { navController.popBackStack() }
                        ) {
                            Text("Go Back")
                        }
                    }
                }
            }

            // Content
            AnimatedVisibility(
                visible = uiState.device != null && !uiState.isLoading,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                uiState.device?.let { device ->
                    DeviceControlContent(
                        device = device,
                        onToggleDevice = { isOn -> viewModel.toggleDevice(isOn) },
                        onUpdateBrightness = { viewModel.updateBrightness(it) },
                        onUpdateTemperature = { viewModel.updateTemperature(it) },
                        insights = uiState.insights,
                        isLoadingInsights = uiState.isLoadingInsights,
                        onCreateAutomation = { automation ->
                            selectedAutomation = automation
                            showAutomationDialog = true
                        },
                        onRefresh = { viewModel.refreshInsights() },
                        onUpdateVolume = {viewModel.updateVolume(it)},
                        onSetTimer = {viewModel.setTimer(it)}
                    )
                }
            }

            if (showDeleteDialog) {
                AlertDialog(
                    onDismissRequest = { showDeleteDialog = false },
                    title = { Text("Delete Device") },
                    text = { Text("Are you sure you want to remove this device? This action cannot be undone.") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                viewModel.deleteDevice()
                                navController.popBackStack()
                            }
                        ) {
                            Text("Delete", color = MaterialTheme.colorScheme.error)
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showDeleteDialog = false }
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }

            if (showAutomationDialog) {
                var selectedDays by remember { mutableStateOf(setOf("Mon", "Tue", "Wed", "Thu", "Fri")) }
                var selectedTime by remember { mutableStateOf("18:00") }

                AlertDialog(
                    onDismissRequest = { showAutomationDialog = false },
                    title = { Text("Create Automation") },
                    text = {
                        Column {
                            Text(
                                text = selectedAutomation,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            Text(
                                text = "Days",
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            // Day selector
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                                days.forEach { day ->
                                    DayChip(
                                        day = day,
                                        selected = selectedDays.contains(day),
                                        onSelectedChange = { selected ->
                                            selectedDays = if (selected) {
                                                selectedDays + day
                                            } else {
                                                selectedDays - day
                                            }
                                        }
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Time",
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            // Time selector (simplified for now)
                            OutlinedTextField(
                                value = selectedTime,
                                onValueChange = { selectedTime = it },
                                modifier = Modifier.fillMaxWidth(),
                                label = { Text("Time") },
                                singleLine = true
                            )
                        }
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                // TODO: Save automation
                                showAutomationDialog = false
                            }
                        ) {
                            Text("Create")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showAutomationDialog = false }
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun DeviceControlContent(
    device: Device,
    onToggleDevice: (Boolean) -> Unit,
    onUpdateBrightness: (Float) -> Unit,
    onUpdateTemperature: (Float) -> Unit,
    insights: DeviceInsights? = null,
    isLoadingInsights: Boolean = false,
    onCreateAutomation: ((String) -> Unit)? = null,
    onRefresh: (() -> Unit)? = null,
    onUpdateVolume: ((Float) -> Unit),
    onSetTimer: ((Int) -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Device status card
        DeviceStatusCard(
            device = device,
            onToggleDevice = onToggleDevice
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Control section based on device type
        when (device.category) {
            DeviceCategory.LIGHT -> {
                LightingControls(
                    device = device,
                    onBrightnessChange = onUpdateBrightness,
                    onToggleDevice = onToggleDevice
                )
            }
            DeviceCategory.THERMOSTAT -> {
                ThermostatControls(
                    device = device,
                    onTemperatureChange = onUpdateTemperature,
                    onToggleDevice = onToggleDevice
                )
            }
            DeviceCategory.SECURITY -> {
                SecurityControls(
                    device = device,
                    onToggleDevice = onToggleDevice,
                )
            }
            DeviceCategory.ENTERTAINMENT -> {
                EntertainmentControls(
                    device = device,
                    onToggleDevice = onToggleDevice,
                    onUpdateVolume = onUpdateVolume
                )
            }
            DeviceCategory.APPLIANCE -> {
                ApplianceControls(
                    device = device,
                    onToggleDevice = onToggleDevice,
                    onSetTimer = onSetTimer
                )
            }
            DeviceCategory.SPEAKER -> {
                SpeakerControl(
                    device = device,
                    onToggleDevice = onToggleDevice,
                    onUpdateVolume = onUpdateVolume
                )
            }
            else -> {
                // Default controls for other categories
                SpeakerControl(
                    device = device,
                    onToggleDevice = onToggleDevice,
                    onUpdateVolume = onUpdateVolume
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Device information card
        DeviceInfoCard(device = device)

        Spacer(modifier = Modifier.height(24.dp))


        AutomationSuggestions(
            device = device,
            insights = insights,
            isLoadingInsights = isLoadingInsights,
            onCreateAutomation = onCreateAutomation,
            onRefresh = onRefresh
        )
    }
}

@Composable
fun DeviceStatusCard(
    device: Device,
    onToggleDevice: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (device.isOn) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = device.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = if (device.isOn) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = device.location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (device.isOn) MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )

                Text(
                    text = if (device.isOn) "ON" else "OFF",
                    style = MaterialTheme.typography.titleMedium,
                    color = if (device.isOn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            FilledIconButton(
                onClick = { onToggleDevice(!device.isOn) },
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Power,
                    contentDescription = if (device.isOn) "Turn Off" else "Turn On",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Composable
fun LightingControls(
    device: Device,
    onBrightnessChange: (Float) -> Unit,
    onToggleDevice: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Lighting Controls",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Brightness",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Brightness percentage
                    val brightnessText = "${(device.brightness * 100).toInt()}%"
                    Text(
                        text = brightnessText,
                        style = MaterialTheme.typography.headlineMedium,
                        color = if (device.isOn) light_color else MaterialTheme.colorScheme.onSurface.copy(
                            alpha = 0.5f
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Brightness indicator
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // Background track
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(4.dp)
                                .align(Alignment.Center)
                                .padding(horizontal = 12.dp)
                                .align(Alignment.Center)
                        )

                        // Active progress
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(device.brightness)
                                .height(8.dp)
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp)
                                .align(Alignment.CenterStart),
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Brightness slider
                    Slider(
                        value = device.brightness,
                        onValueChange = { onBrightnessChange(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .height(48.dp), // Increase height for better touch target
                        enabled = device.isOn,
                        valueRange = 0f..1f,
                        steps = 10 // Reduced steps for smoother sliding
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Label row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "0%",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "100%",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Lighting Modes",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Mode selection cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LightingModeCard(
                    name = "Normal",
                    isSelected = true,
                    isEnabled = device.isOn,
                    onClick = { /* TODO: Implement mode selection */ }
                )

                LightingModeCard(
                    name = "Reading",
                    isSelected = false,
                    isEnabled = device.isOn,
                    onClick = { /* TODO: Implement mode selection */ }
                )

                LightingModeCard(
                    name = "Night",
                    isSelected = false,
                    isEnabled = device.isOn,
                    onClick = { /* TODO: Implement mode selection */ }
                )
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LightingModeCard(
        name: String,
        isSelected: Boolean,
        isEnabled: Boolean,
        onClick: () -> Unit
    ) {
        val cardColor = when {
            !isEnabled -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            isSelected -> MaterialTheme.colorScheme.primaryContainer
            else -> MaterialTheme.colorScheme.surface
        }

        val textColor = when {
            !isEnabled -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            isSelected -> MaterialTheme.colorScheme.onPrimaryContainer
            else -> MaterialTheme.colorScheme.onSurface
        }

        Card(
            onClick = { if (isEnabled) onClick() },
            modifier = Modifier
                .width(100.dp)
                .height(80.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            ),
            enabled = isEnabled
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
@Composable
fun ThermostatControls(
    device: Device,
    onTemperatureChange: (Float) -> Unit,
    onToggleDevice: (Boolean) -> Unit
) {
    // Convert Fahrenheit to Celsius if needed
    fun fahrenheitToCelsius(fahrenheit: Float): Float {
        return (fahrenheit - 32f) * 5f / 9f
    }

    // Convert Celsius to Fahrenheit for backend storage
    fun celsiusToFahrenheit(celsius: Float): Float {
        return celsius * 9f / 5f + 32f
    }


    val currentTempF = device.properties?.get("temperature")?.toFloatOrNull() ?: 72f
    val currentTempC = fahrenheitToCelsius(currentTempF).coerceIn(18f, 30f)
    val tempCState = remember(device.id) {
        mutableStateOf(
            fahrenheitToCelsius(
                device.properties?.get("temperature")?.toFloatOrNull() ?: 72f
            ).coerceIn(18f, 30f)
        )
    }


    val tempColor = when {
        currentTempC < 20f -> temperature_cold
        currentTempC > 26f -> temperature_warm
        else -> MaterialTheme.colorScheme.primary
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title with icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Climate Control",
                        style = MaterialTheme.typography.titleMedium
                    )

                    // Large power button
                    FilledIconButton(
                        onClick = {
                            onToggleDevice(!device.isOn)
                        },
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = if (device.isOn)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {

                    }
                }

                val animatedTempC by animateFloatAsState(
                    targetValue = currentTempC,
                    animationSpec = tween(durationMillis = 500)
                )

                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            alpha = if (device.isOn) 1f else 0.5f
                        }
                    CircularProgressIndicator(
                        progress = {(animatedTempC - 18f) / (30f - 18f)},
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer {
                                alpha = if (device.isOn) 1f else 0.5f
                            },
                        color = if (device.isOn) tempColor else MaterialTheme.colorScheme.surfaceVariant,
                        strokeWidth = 12.dp,
                        strokeCap = StrokeCap.Round
                    )

                    Text(
                        text = "${animatedTempC.toInt()}°C",
                        style = MaterialTheme.typography.displayMedium,
                        color = if (device.isOn)
                            MaterialTheme.colorScheme.onSurface
                        else
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Slider(
                    value = currentTempC,
                    onValueChange = {
                        onTemperatureChange(celsiusToFahrenheit(it))                    },
                    valueRange = 18f..30f,
                    steps = 12, // One step per degree
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .height(48.dp), // Increase height for better touch target
                    enabled = device.isOn
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Label row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "18°C",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "30°C",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Mode",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ThermostatModeCard(
                        name = "Cool",
                        isSelected = true,
                        isEnabled = device.isOn,
                        onClick = { /* TODO: Implement mode selection */ }
                    )

                    ThermostatModeCard(
                        name = "Heat",
                        isSelected = false,
                        isEnabled = device.isOn,
                        onClick = { /* TODO: Implement mode selection */ }
                    )

                    ThermostatModeCard(
                        name = "Auto",
                        isSelected = false,
                        isEnabled = device.isOn,
                        onClick = { /* TODO: Implement mode selection */ }
                    )
                }
            }
        }
    }
}

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun ThermostatModeCard(
            name: String,
            isSelected: Boolean,
            isEnabled: Boolean,
            onClick: () -> Unit
        ) {
            val cardColor = when {
                !isEnabled -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                isSelected -> MaterialTheme.colorScheme.primaryContainer
                else -> MaterialTheme.colorScheme.surface
            }

            val textColor = when {
                !isEnabled -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                isSelected -> MaterialTheme.colorScheme.onPrimaryContainer
                else -> MaterialTheme.colorScheme.onSurface
            }

            Card(
                onClick = { if (isEnabled) onClick() },
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor
                ),
                enabled = isEnabled
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.bodyLarge,
                        color = textColor,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

@Composable
fun SecurityControls(
    device: Device,
    onToggleDevice: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Security Controls",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val securityStatus = if (device.isOn) "SYSTEM ARMED" else "SYSTEM DISARMED"
                val statusColor = if (device.isOn) security_safe else security_alert

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = securityStatus,
                        style = MaterialTheme.typography.headlineMedium,
                        color = statusColor
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (device.isOn) {
                            "Monitoring for activity"
                        } else {
                            "Security system inactive"
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                if (!device.isOn) {
                    Button(
                        onClick = { onToggleDevice(true) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(
                            text = "ARM SECURITY SYSTEM",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                } else {
                    Button(
                        onClick = { onToggleDevice(false) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = security_alert
                        )
                    ) {
                        Text(
                            text = "DISARM SYSTEM",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quick Toggle",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    Switch(
                        checked = device.isOn,
                        onCheckedChange = { newState ->
                            onToggleDevice(newState)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EntertainmentControls(
    device: Device,
    onToggleDevice: (Boolean) -> Unit,
    onUpdateVolume: ((Float) -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Entertainment Controls",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Power status
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {



                }

                Spacer(modifier = Modifier.height(8.dp))

                if (device.isOn) {
                    // Volume control
                    Text(
                        text = "Volume",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )

                    val currentVolume = device.properties?.get("volume")?.toFloatOrNull() ?: 0.5f

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${(currentVolume * 100).toInt()}%",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Slider(
                            value = currentVolume,
                            onValueChange = { newVolume ->
                                onUpdateVolume?.invoke(newVolume)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            enabled = device.isOn
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Currently Playing",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Text(
                        text = device.properties?.get("current_media") ?: "No media selected",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Device is off",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Turn on to control",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ApplianceControls(
    device: Device,
    onToggleDevice: (Boolean) -> Unit,
    onSetTimer: ((Int) -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Appliance Controls",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Power status
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                }

                Spacer(modifier = Modifier.height(16.dp))

                // Timer controls
                if (device.isOn) {
                    var timerMinutes by remember { mutableStateOf(30f) }

                    Text(
                        text = "Timer (minutes)",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${timerMinutes.toInt()} min",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Slider(
                            value = timerMinutes,
                            onValueChange = { timerMinutes = it },
                            valueRange = 5f..120f,
                            steps = 23, // 5-minute increments
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                onSetTimer?.invoke(timerMinutes.toInt())
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Timer,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Set Timer")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Appliance status
                val statusText = if (device.isOn) "Running" else "Off"
                val runTime = device.properties?.get("run_time")

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = statusText,
                        style = MaterialTheme.typography.headlineSmall,
                        color = if (device.isOn) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        }
                    )

                    if (device.isOn && runTime != null) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Running for: $runTime",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SpeakerControl(
    device: Device,
    onToggleDevice: (Boolean) -> Unit,
    onUpdateVolume: ((Float) -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Speaker Controls",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {


                Spacer(modifier = Modifier.height(16.dp))

                if (device.isOn) {
                    // Volume control
                    Text(
                        text = "Volume",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    val currentVolume = device.properties?.get("volume")?.toFloatOrNull() ?: 0.5f

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${(currentVolume * 100).toInt()}%",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Slider(
                            value = currentVolume,
                            onValueChange = { newVolume ->
                                onUpdateVolume?.invoke(newVolume)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            enabled = device.isOn
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Current track info
                    val currentTrack = device.properties?.get("current_track") ?: "No track selected"
                    val currentArtist = device.properties?.get("current_artist") ?: "Unknown artist"

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Now Playing",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = currentTrack,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = currentArtist,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Speaker is off",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Turn on to control",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
    }
}
 @Composable
            fun DeviceInfoCard(device: Device) {
                OutlinedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Device Information",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        DeviceInfoRow(label = "Type", value = device.category.displayName)
                        DeviceInfoRow(label = "Location", value = device.location)
                        DeviceInfoRow(label = "Device ID", value = device.id)
                        DeviceInfoRow(label = "Firmware", value = "v${device.properties?.get("firmwareVersion") ?: "1.0.0"}")
                        DeviceInfoRow(label = "Status", value = if (device.isOn) "Online" else "Offline")
                    }
                }
            }

            @Composable
            fun DeviceInfoRow(
                label: String,
                value: String
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = value,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }



            @Composable
            fun AutomationSuggestions(
                device: Device,
                insights: DeviceInsights? = null,
                isLoadingInsights: Boolean = false,
                onCreateAutomation: ((String) -> Unit)? = null,
                onRefresh: (() -> Unit)? = null
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "AI Insights & Predictions",
                                style = MaterialTheme.typography.titleMedium
                            )

                            insights?.confidenceScore?.let { score ->
                                if (score > 0) {
                                    Text(
                                        text = "AI prediction confidence: ${(score * 100).toInt()}%",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                                    )
                                }
                            }
                        }

                        // Refresh button with animation
                        var isRefreshing by remember { mutableStateOf(false) }
                        val rotationAnimation by animateFloatAsState(
                            targetValue = if (isRefreshing) 360f else 0f,
                            animationSpec = tween(durationMillis = 1000)
                        )

                        IconButton(
                            onClick = {
                                isRefreshing = true
                                onRefresh?.invoke()
                                // Automatically reset after animation completes
                                kotlinx.coroutines.MainScope().launch {
                                    kotlinx.coroutines.delay(1000)
                                    isRefreshing = false
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Refresh insights",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .size(24.dp)
                                    .graphicsLayer { rotationZ = rotationAnimation }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            if (isLoadingInsights) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(24.dp),
                                        strokeWidth = 2.dp
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        text = "Loading advanced insights...",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            } else if (insights != null && insights.available && insights.insights != null) {
                                // Show AI insights
                                val insightsData = insights.insights
                                var expandedSection by remember { mutableStateOf<String?>(null) }

                                if (!insightsData.predictiveAutomations.isNullOrEmpty()) {
                                    SectionHeader(title = "Predictive Automations")

                                    insightsData.predictiveAutomations.take(2).forEach { suggestion ->
                                        AutomationSuggestionItem(
                                            title = "Predictive Automation",
                                            description = suggestion,
                                            onClick = { onCreateAutomation?.invoke(suggestion) },
                                            highlight = true
                                        )
                                        Spacer(modifier = Modifier.height(12.dp))
                                    }
                                }
                                else if (!insightsData.automationSuggestions.isNullOrEmpty()) {
                                    SectionHeader(title = "Smart Automations")

                                    insightsData.automationSuggestions.take(2).forEach { suggestion ->
                                        AutomationSuggestionItem(
                                            title = "Smart Automation",
                                            description = suggestion,
                                            onClick = { onCreateAutomation?.invoke(suggestion) }
                                        )
                                        Spacer(modifier = Modifier.height(12.dp))
                                    }
                                }

                                if (!insightsData.seasonalAdjustments.isNullOrEmpty()) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    SectionHeader(title = "Seasonal Recommendations")

                                    insightsData.seasonalAdjustments.take(1).forEach { adjustment ->
                                        AutomationSuggestionItem(
                                            title = "Seasonal Adjustment",
                                            description = adjustment,
                                            chipColor = MaterialTheme.colorScheme.tertiary
                                        )
                                    }
                                }

                                if (!insightsData.anomalies.isNullOrEmpty()) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    ExpandableSection(
                                        title = "Unusual Patterns Detected",
                                        expanded = expandedSection == "anomalies",
                                        onToggle = {
                                            expandedSection = if (expandedSection == "anomalies") null else "anomalies"
                                        },
                                        iconTint = MaterialTheme.colorScheme.error
                                    ) {
                                        Column {
                                            insightsData.anomalies.forEach { anomaly ->
                                                AutomationSuggestionItem(
                                                    title = "Unusual Pattern",
                                                    description = anomaly,
                                                    chipColor = MaterialTheme.colorScheme.error
                                                )
                                                Spacer(modifier = Modifier.height(8.dp))
                                            }
                                        }
                                    }
                                }

                                // Display energy saving tips
                                if (!insightsData.energySavingTips.isNullOrEmpty()) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    ExpandableSection(
                                        title = "Energy Saving Tips",
                                        expanded = expandedSection == "energy",
                                        onToggle = {
                                            expandedSection = if (expandedSection == "energy") null else "energy"
                                        }
                                    ) {
                                        Column {
                                            insightsData.energySavingTips.forEach { tip ->
                                                AutomationSuggestionItem(
                                                    title = "Energy Saving Tip",
                                                    description = tip
                                                )
                                                Spacer(modifier = Modifier.height(8.dp))
                                            }
                                        }
                                    }
                                }

                                // Display routines section
                                if (!insightsData.routines.isNullOrEmpty()) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    ExpandableSection(
                                        title = "Detected Routines",
                                        expanded = expandedSection == "routines",
                                        onToggle = {
                                            expandedSection = if (expandedSection == "routines") null else "routines"
                                        },
                                        iconTint = MaterialTheme.colorScheme.secondary
                                    ) {
                                        Column {
                                            insightsData.routines.forEach { routine ->
                                                AutomationSuggestionItem(
                                                    title = "User Routine",
                                                    description = routine,
                                                    chipColor = MaterialTheme.colorScheme.secondary
                                                )
                                                Spacer(modifier = Modifier.height(8.dp))
                                            }
                                        }
                                    }
                                }
                            } else if (insights != null && insights.suggestedAutomations != null) {
                                // Show suggested automations from backend
                                SectionHeader(title = "Suggested Automations")

                                insights.suggestedAutomations.take(2).forEach { suggestion ->
                                    AutomationSuggestionItem(
                                        title = "Suggested Automation",
                                        description = suggestion,
                                        onClick = { onCreateAutomation?.invoke(suggestion) }
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                }
                            } else if (insights != null && !insights.available) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CloudOff,
                                        contentDescription = "AI unavailable",
                                        tint = MaterialTheme.colorScheme.error.copy(alpha = 0.7f),
                                        modifier = Modifier.size(32.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = insights.message ?: "AI insights temporarily unavailable",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.error,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Button(
                                        onClick = { onRefresh?.invoke() },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Refresh,
                                            contentDescription = "Refresh",
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text("Try Again")
                                    }
                                }
                            } else {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "AI insights not available for this device yet",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Button(
                                        onClick = { onRefresh?.invoke() },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Refresh,
                                            contentDescription = "Refresh",
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text("Load Insights")
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Composable
            fun AutomationSuggestionItem(
                title: String,
                description: String,
                onClick: (() -> Unit)? = null,
                highlight: Boolean = false,
                chipColor: Color = MaterialTheme.colorScheme.primary
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = MaterialTheme.shapes.small,
                    tonalElevation = if (highlight) 3.dp else 0.dp,
                    color = if (highlight)
                        MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
                    else
                        MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .then(
                                if (onClick != null)
                                    Modifier.clickable(onClick = onClick)
                                else
                                    Modifier
                            )
                            .padding(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val icon = when {
                                title.contains("Predictive") -> Icons.Default.Timer
                                title.contains("Energy") -> Icons.Default.Power
                                title.contains("Anomaly") || title.contains("Unusual") -> Icons.Default.Info
                                else -> Icons.Default.Timer
                            }

                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = chipColor,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = title,
                                style = MaterialTheme.typography.labelMedium,
                                color = chipColor
                            )

                            if (highlight) {
                                Spacer(modifier = Modifier.width(8.dp))
                                Surface(
                                    shape = MaterialTheme.shapes.extraSmall,
                                    color = MaterialTheme.colorScheme.error.copy(alpha = 0.2f),
                                    contentColor = MaterialTheme.colorScheme.error
                                ) {
                                    Text(
                                        text = "New",
                                        style = MaterialTheme.typography.labelSmall,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                }
            }

            @Composable
            fun SectionHeader(title: String) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            @Composable
            fun ExpandableSection(
                title: String,
                expanded: Boolean,
                onToggle: () -> Unit,
                iconTint: Color = MaterialTheme.colorScheme.primary,
                content: @Composable () -> Unit
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = onToggle)
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleSmall,
                            color = iconTint
                        )

                        Icon(
                            imageVector = if (expanded) Icons.Default.Close else Icons.Default.Timer,
                            contentDescription = if (expanded) "Collapse" else "Expand",
                            tint = iconTint,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    AnimatedVisibility(
                        visible = expanded,
                        enter = fadeIn() + expandVertically(),
                        exit = fadeOut() + shrinkVertically()
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            shape = MaterialTheme.shapes.small,
                            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                            tonalElevation = 1.dp
                        ) {
                            Box(modifier = Modifier.padding(8.dp)) {
                                content()
                            }
                        }
                    }
                }
            }





            @OptIn(ExperimentalMaterial3Api::class)
            @Composable
            fun DayChip(
                day: String,
                selected: Boolean,
                onSelectedChange: (Boolean) -> Unit
            ) {
                FilterChip(
                    selected = selected,
                    onClick = { onSelectedChange(!selected) },
                    label = {
                        Text(
                            text = day,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                    },
                    modifier = Modifier.padding(end = 4.dp)
                )
            }