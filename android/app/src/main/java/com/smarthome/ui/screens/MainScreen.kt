package com.smarthome.ui.screens

import com.smarthome.viewmodel.DevicesViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smarthome.ui.navigation.BottomNavBar
import com.smarthome.ui.navigation.BottomNavItem
import com.smarthome.ui.navigation.NavRoutes
import com.smarthome.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    outerNavController: NavController,
    devicesViewModel: DevicesViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val innerNavController = rememberNavController()
    var bottomNavVisible by remember { mutableStateOf(true) }


    val navItems = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Devices,
        BottomNavItem.Settings,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = innerNavController,
                items = navItems,
                visible = bottomNavVisible,
                onItemClick = { navItem ->
                    innerNavController.navigate(navItem.route) {

                        popUpTo(innerNavController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = innerNavController,
            startDestination = NavRoutes.DASHBOARD,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = NavRoutes.DASHBOARD) {
                DashboardScreen(
                    onDeviceClick = { deviceId ->
                        outerNavController.navigate("${NavRoutes.DEVICE_CONTROL}/$deviceId")
                    },
                    onAddDeviceClick = {
                        outerNavController.navigate(NavRoutes.ADD_DEVICE)
                    }
                )
            }

            composable(route = NavRoutes.DEVICES) {
                DevicesScreen(
                    onDeviceClick = { deviceId ->
                        outerNavController.navigate("${NavRoutes.DEVICE_CONTROL}/$deviceId")
                    },
                    onAddDeviceClick = {
                        outerNavController.navigate(NavRoutes.ADD_DEVICE)
                    }
                )
            }

            composable(route = NavRoutes.SETTINGS) {
                SettingsScreen(
                    onSignOut = {
                        profileViewModel.signOut()
                        outerNavController.navigate(NavRoutes.LOGIN) {
                            popUpTo(NavRoutes.HOME) { inclusive = true }
                        }
                    }
                )
            }

            composable(route = NavRoutes.PROFILE) {
                ProfileScreen(
                    onSettingsClick = {
                        innerNavController.navigate(NavRoutes.SETTINGS)
                    },
                    onSignOut = {
                        profileViewModel.signOut()
                        outerNavController.navigate(NavRoutes.LOGIN) {
                            popUpTo(NavRoutes.HOME) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}