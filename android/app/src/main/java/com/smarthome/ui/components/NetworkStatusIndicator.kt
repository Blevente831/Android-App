package com.smarthome.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.SignalCellular4Bar
import androidx.compose.material.icons.filled.SignalCellularAlt
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// Using centralized ConnectionStatus from ConnectionStatus.kt

enum class ConnectionStatus {
    CONNECTED,
    CONNECTING,
    DISCONNECTED,
    UNKNOWN
}
enum class ConnectionType {
    WIFI,
    CELLULAR,
    NONE
}

@Composable
fun NetworkStatusIndicator(
    connectionStatus: ConnectionStatus,
    connectionType: ConnectionType,
    modifier: Modifier = Modifier
) {
    val statusColor = when (connectionStatus) {
        ConnectionStatus.CONNECTED -> Color.Green
        ConnectionStatus.CONNECTING -> Color.Yellow
        ConnectionStatus.DISCONNECTED -> Color.Red
        ConnectionStatus.UNKNOWN -> Color(0xFFFFA500) // Orange
    }

    val statusText = when (connectionStatus) {
        ConnectionStatus.CONNECTED -> "Connected"
        ConnectionStatus.CONNECTING -> "Connecting..."
        ConnectionStatus.DISCONNECTED -> "Disconnected"
        ConnectionStatus.UNKNOWN -> "Unstable Connection"
    }

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ), label = "alpha"
    )

    val displayAlpha = if (connectionStatus == ConnectionStatus.CONNECTING) alpha else 1.0f

    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Status indicator
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(statusColor.copy(alpha = displayAlpha))
        )

        // Connection type icon
        Icon(
            imageVector = when (connectionType) {
                ConnectionType.WIFI -> Icons.Default.Wifi
                ConnectionType.CELLULAR -> Icons.Default.SignalCellularAlt
                ConnectionType.NONE -> Icons.Default.CloudOff
            },
            contentDescription = "Connection Type",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(16.dp)
        )

        // Status text
        Text(
            text = statusText,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


@Composable
@Deprecated("Use EnhancedNetworkStatusIndicator instead for improved visual feedback",
    replaceWith = ReplaceWith("EnhancedNetworkStatusIndicator"))
fun AnimatedNetworkStatusIndicator(
    isVisible: Boolean,
    connectionStatus: ConnectionStatus,
    connectionType: ConnectionType,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut(),
        modifier = modifier
    ) {
        NetworkStatusIndicator(
            connectionStatus = connectionStatus,
            connectionType = connectionType
        )
    }
}