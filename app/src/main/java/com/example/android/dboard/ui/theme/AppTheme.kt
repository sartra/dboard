package com.example.android.dboard.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(
    colors: Colors = appColors,
    typography: AppTypography = appTypography,
    shapes: Shapes = appShapes,
    content: @Composable () -> Unit,
) {
    BaseTheme(
        content = content,
        colors = colors,
        typography = typography,
        shapes = shapes,
    )
}

object AppTheme {
    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current

    val shapes: Shapes
        @Composable
        get() = appShapes

    val colors: Colors
        @Composable
        get() = appColors
}

@Composable
private fun BaseTheme(
    content: @Composable () -> Unit,
    colors: Colors,
    typography: AppTypography,
    shapes: Shapes,
) {
    ProvideAppTypography(typography) {
        MaterialTheme(
            colors = colors,
            shapes = shapes,
            content = content
        )
    }
}

@Composable
fun ProvideAppTypography(
    typography: AppTypography,
    content: @Composable () -> Unit
) {
    val typeScale = remember {
        typography.copy()
    }
    CompositionLocalProvider(LocalAppTypography provides typeScale, content = content)
}

private val LocalAppTypography = staticCompositionLocalOf<AppTypography> {
    error("No DiscoveryTypeScale provided")
}
