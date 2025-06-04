package com.example.learning.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


/**
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun LearningTheme(
    darkTheme: Boolean = true /*|| isSystemInDarkTheme()*/,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
 */

private val BlockDarkColorScheme = darkColorScheme(
    primary = Color(0xFF00FFFF),          // Cyan
    onPrimary = Color.Black,
    secondary = Color(0xFF1DE9B6),        // Teal
    onSecondary = Color.Black,
    background = Color(0xFF0A0E23),       // Deep navy blue
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White,
    error = Color(0xFFFF5252)
)

private val BlockLightColorScheme = lightColorScheme(
    primary = Color(0xFF00B0FF),          // Light Blue
    onPrimary = Color.White,
    secondary = Color(0xFF1DE9B6),
    onSecondary = Color.Black,
    background = Color(0xFFF0F4F8),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFD32F2F)
)

@Composable
fun BlockchainAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) BlockDarkColorScheme else BlockLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = BlockTypography, // 可後續自訂字型風格
        content = content
    )
}
