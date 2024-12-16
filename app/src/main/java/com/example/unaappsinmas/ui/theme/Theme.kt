package com.example.unaappsinmas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,
    secondary = MintSecondary,
    background = BackgroundLight,
    surface = BackgroundLight,
    onPrimary = BackgroundLight, // Texto en botones primarios
    onSecondary = BackgroundLight, // Texto en botones secundarios
    onBackground = TextPrimaryLight,
    onSurface = TextPrimaryLight
)

private val DarkColorScheme = darkColorScheme(
    primary = PurplePrimary,
    secondary = MintSecondary,
    background = BackgroundDark,
    surface = BackgroundDark,
    onPrimary = BackgroundDark, // Texto en botones primarios
    onSecondary = BackgroundDark, // Texto en botones secundarios
    onBackground = TextPrimaryDark,
    onSurface = TextPrimaryDark
)

@Composable
fun UnaAppSinMasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}