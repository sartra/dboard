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
fun SpaceBarIcon() {
    Image(
        modifier = Modifier.height(22.dp),
        painter = painterResource(R.drawable.ic_spacebar),
        contentDescription = stringResource(R.string.space),
        alignment = Alignment.Center
    )
}

@Preview
@Composable
fun SpaceIconPreview() {
    SpaceBarIcon()
}
