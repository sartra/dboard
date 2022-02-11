package com.example.android.dboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BackspaceIcon() {
    Image(
        modifier = Modifier.height(18.dp),
        painter = painterResource(R.drawable.ic_backspace),
        contentDescription = stringResource(R.string.backspace),
        alignment = Alignment.Center
    )
}

@Preview
@Composable
fun BackspaceIconPreview() {
    BackspaceIcon()
}
