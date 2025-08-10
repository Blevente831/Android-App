package com.smarthome.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,

    primaryContainer = Purple40.copy(alpha = 0.2f),
    onPrimaryContainer = Purple10
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,

    primaryContainer = Purple90,
    onPrimaryContainer = Purple10,


)

@Composable
fun SmartHomeTheme(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val themeState by themeViewModel.state.collectAsState()
    val currentSystemDarkTheme = isSystemInDarkTheme()
    val context = LocalContext.current
    val themeEventBus = remember { (themeViewModel as? ThemeViewModel)?.themeEventBus }

    // Determine if dark theme should be used
    val darkTheme = when (themeState.themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> currentSystemDarkTheme
    }

    if (themeEventBus != null) {
        // Theme change callback
        val themeChangeCallback = remember {
            {
                println("Theme change event received")
                if (context is Activity) {
                    context.recreate()
                }
            }
        }

        // Register/unregister with theme change event bus
        DisposableEffect(themeEventBus) {
            themeEventBus.registerListener(themeChangeCallback)
            onDispose {
                themeEventBus.unregisterListener(themeChangeCallback)
            }
        }
    }

    // Update current activity reference
    LaunchedEffect(Unit) {
        val activity = context as? Activity
        if (activity != null) {
            themeViewModel.updateCurrentActivity(activity)
        }
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme

            // Log current theme mode for debugging
            println("Applying theme: ${themeState.themeMode}, isDark: $darkTheme")
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}