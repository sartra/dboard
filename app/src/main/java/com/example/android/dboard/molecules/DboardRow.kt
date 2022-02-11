package com.example.android.dboard.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android.dboard.model.DboardButtonModel

@Composable
fun DboardRow(
    buttons: List<DboardButtonModel>,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in buttons) {
            DboardButton(
                i,
                modifier = Modifier.weight(1F)
            )
        }
    }
}
