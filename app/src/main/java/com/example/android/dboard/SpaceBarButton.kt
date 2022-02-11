package com.example.android.dboard

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpaceBarButton() {
    Box(contentAlignment = Alignment.Center) {
        SpaceBarIcon()
    }
}

@Preview
@Composable
fun SpaceBarButtonPreview() {
    SpaceBarButton()
}
