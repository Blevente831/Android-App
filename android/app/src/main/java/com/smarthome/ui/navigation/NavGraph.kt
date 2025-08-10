package com.smarthome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.smarthome.ui.screens.*
import com.smarthome.viewmodel.ProfileViewModel
import androidx.hilt.navigation.compose.hiltViewModel

// Parameter routes
fun deviceDetailRoute(deviceId: String) = "${NavRoutes.DEVICE_CONTROL}/$deviceId"

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = NavRoutes.LOGIN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Authentication screens
        composable(route = NavRoutes.LOGIN) {
            LoginScreen(
                onNavigateToSignUp = { navController.navigate(NavRoutes.REGISTER) },
                onLoginSuccess = {
                    navController.navigate(NavRoutes.HOME) {
                        popUpTo(NavRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(route = NavRoutes.REGISTER) {
            SignUpScreen(
                onNavigateBack = { navController.popBackStack() },
                onSignUpSuccess = {
                    navController.navigate(NavRoutes.HOME) {
                        popUpTo(NavRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        // Main screen (contains bottom navigation)
        composable(route = NavRoutes.HOME) {
            MainScreen(
                outerNavController = navController
            )
        }

        // Detail screens
        composable(
            route = "${NavRoutes.DEVICE_CONTROL}/{deviceId}",
            arguments = listOf(navArgument("deviceId") { type = NavType.StringType })
        ) { backStackEntry ->
            val deviceId = backStackEntry.arguments?.getString("deviceId") ?: ""
            DeviceControlScreen(
                deviceId = deviceId,
                navController = navController
            )
        }




        composable(route = NavRoutes.ADD_DEVICE) {
            AddDeviceScreen(
                onNavigateBack = { navController.popBackStack() },
                onSetupWifi = { navController.navigate(NavRoutes.NETWORK_CONFIG) }
            )
        }
    }
}