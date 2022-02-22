package com.example.android.dboard.molecules

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.ui.DboardButtonType

@Composable
fun DboardRow(
    buttons: List<DboardButtonModel>,
    hasFocus: Boolean,
    focusRequester: FocusRequester = FocusRequester()
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        val spaceWeight = ( 5 - buttons.size).toFloat()  // col size - 1 (space) - buttons.size
        val buttonsSize = buttons.size
        println("~~~buttons: $buttonsSize")
        println("~~~spaceWeight: $spaceWeight")
        for (button in buttons) {
            val weight = if (button.type == DboardButtonType.Space) spaceWeight else 1F

            if (hasFocus){
                DboardButton(
                    button,
                    modifier = Modifier
                        .weight(weight)
                        .height(40.dp),
                    focusRequester
                )
            } else {
                DboardButton(
                    button,
                    modifier = Modifier
                        .weight(weight)
                        .height(40.dp),
                )
            }
        }
    }
}
