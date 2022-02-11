package com.example.android.dboard.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.R

@Composable
fun DeleteIcon() {
    Image(
        modifier = Modifier.height(18.dp),
        painter = painterResource(R.drawable.ic_delete),
        contentDescription = stringResource(R.string.delete_char),
        alignment = Alignment.Center
    )
}

@Preview
@Composable
fun DeleteIconPreview() {
    DeleteIcon()
}
