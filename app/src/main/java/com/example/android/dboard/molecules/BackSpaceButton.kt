package com.example.android.dboard.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.dboard.BackspaceIcon

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
