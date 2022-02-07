package com.example.android.dboard.ui.theme

import androidx.compose.runtime.Composable

@Composable
fun DPlusTheme(
    content: @Composable () -> Unit
) {
    AppTheme(
        content = content,
        colors = DPlusColors,
        typography = DPlusTypography,
        shapes = DPlusShapes,
    )
}
