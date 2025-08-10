package com.smarthome.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.smarthome.R

sealed class BottomNavItem(
    val route: String,
    val iconId: Int,
    val title: String
) {
    object Dashboard : BottomNavItem(
        route = NavRoutes.DASHBOARD,
        iconId = R.drawable.ic_dashboard,
        title = "Dashboard"
    )

    object Devices : BottomNavItem(
        route = NavRoutes.DEVICES,
        iconId = R.drawable.ic_devices,
        title = "Devices"
    )

    object Settings : BottomNavItem(
        route = NavRoutes.SETTINGS,
        iconId = R.drawable.ic_settings,
        title = "Settings"
    )

    object Profile : BottomNavItem(
        route = NavRoutes.PROFILE,
        iconId = R.drawable.ic_profile,
        title = "Profile"
    )
}

@Composable
fun BottomNavBar(
    navController: NavController,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Devices,
        BottomNavItem.Settings,
        BottomNavItem.Profile
    ),
    visible: Boolean = true,
    onItemClick: (BottomNavItem) -> Unit
) {
    // Get current route to know which item to highlight
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Calculate elevation as animation when switching items
    val elevationAnimation by animateDpAsState(
        targetValue = if (visible) 16.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "ElevationAnimation"
    )

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        NavigationBar(
            modifier = Modifier
                .navigationBarsPadding()
                .shadow(elevationAnimation),
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {
            items.forEach { item ->
                val isSelected = currentRoute == item.route

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = item.iconId),
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(text = item.title) },
                    selected = isSelected,
                    onClick = { onItemClick(item) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        }
    }
}