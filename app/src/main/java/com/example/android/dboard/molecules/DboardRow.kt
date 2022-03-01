package com.example.android.dboard.molecules

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.model.Key
import com.example.android.dboard.ui.DboardButtonType

//@Composable
//fun DboardRow(
//    buttons: List<Key>,
//    hasFocus: Boolean,
//    focusRequester: FocusRequester = FocusRequester()
//) {
//    Row(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        val colSize = 6
//        // predicate determine if key is char
//        val predicate: (key: Key) -> Boolean = { key ->
//            when (key) {
//                is Key.Char -> true
//                is Key.Action -> false
//            }
//        }
//        val charButtonsInRow = buttons.count(predicate)
//        val spaceWeight = (colSize - charButtonsInRow).toFloat()
//
//        for (button in buttons) {
//            val weight = if (button.type == DboardButtonType.Space) spaceWeight else 1F
//
//            if (hasFocus){
//                DboardButton(
//                    button,
//                    modifier = Modifier
//                        .weight(weight),
//                    focusRequester
//                )
//            } else {
//                DboardButton(
//                    button,
//                    modifier = Modifier
//                        .weight(weight)
//                )
//            }
//        }
//    }
//}



@Composable
fun DboardRowz(
    buttons: List<DboardButtonModel>,
    hasFocus: Boolean,
    focusRequester: FocusRequester = FocusRequester()
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        val colSize = 6
        val predicate: (DboardButtonModel) -> Boolean = {it.type == DboardButtonType.Char}
        val charButtonsInRow = buttons.count(predicate)
        val spaceWeight = (colSize - charButtonsInRow).toFloat()

        for (button in buttons) {
            val weight = if (button.type == DboardButtonType.Space) spaceWeight else 1F

            if (hasFocus){
                DboardButton(
                    button,
                    modifier = Modifier
                        .weight(weight),
                    focusRequester
                )
            } else {
                DboardButton(
                    button,
                    modifier = Modifier
                        .weight(weight)
                )
            }
        }
    }
}
