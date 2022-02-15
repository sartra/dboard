package com.example.android.dboard.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import com.example.android.dboard.model.DboardButtonModel

@Composable
fun DboardRow(
    buttons: List<DboardButtonModel>,
    hasFocus: Boolean,
    focusRequester: FocusRequester = FocusRequester()
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (button in buttons) {
            if (hasFocus){
                DboardButton(
                    button,
                    modifier = Modifier.weight(1F),
                    focusRequester
                )
            } else {
                DboardButton(
                    button,
                    modifier = Modifier.weight(1F),
                )
            }
        }
    }
}
