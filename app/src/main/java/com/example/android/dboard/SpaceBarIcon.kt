package com.example.android.dboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpaceBarIcon() {
    Image(
        modifier = Modifier.padding(top = dimensionResource(R.dimen.grid_4), start = dimensionResource(R.dimen.grid_8)),
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
