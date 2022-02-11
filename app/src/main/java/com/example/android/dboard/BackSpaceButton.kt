package com.example.android.dboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackSpaceButton() {
    Box(contentAlignment = Alignment.Center) {
        BackspaceIcon()
    }
}

@Preview
@Composable
fun BackSpaceButtonPreview() {
    BackSpaceButton()
}
