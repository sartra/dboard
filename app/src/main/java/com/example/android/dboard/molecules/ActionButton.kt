package com.example.android.dboard.molecules

import android.view.KeyEvent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.model.Key
import com.example.android.dboard.organisms.actionTypeIconRouter
import com.example.android.dboard.ui.theme.BrandPrimary
import com.example.android.dboard.ui.theme.Neutral3

const val colSize = 6

@Composable
fun ActionButton(
    actionBtn: Key.Action,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester = FocusRequester()
) {
//    val predicate: (key: Key) -> Boolean = { key ->
//        when (key) {
//            is Key.Char -> true
//            is Key.Action -> false
//        }
//    }
//    // returns how many char keys are in the row - to determine space width
//    val charButtonsInRow = DboardModel.keys.count(predicate)
//    val spaceWeight = (colSize - charButtonsInRow).toFloat()

    var buttonColor by remember { mutableStateOf(Neutral3) }
    Button(
        modifier = modifier
            .requiredHeight(52.dp)
            .clickable { focusRequester.requestFocus() }
            // The focusRequester should be added BEFORE the focusable.
            .focusRequester(focusRequester)
            // The onFocusChanged should be added BEFORE the focusable that is being observed.
            .onFocusChanged { buttonColor = if (it.isFocused) BrandPrimary else Neutral3 }
            .focusTarget()
            .focusable(true)
            .onKeyEvent {
                if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_DPAD_CENTER ||
                    it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER && it.nativeKeyEvent.action == KeyEvent.ACTION_DOWN
                ) {
                    focusRequester.requestFocus()
//                    model.callback()
                }
                false
            }
            .padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        onClick = {
            actionBtn.onClick(actionBtn.type)
            focusRequester.requestFocus()
        }
    ) {
        Icon(
            painter = actionTypeIconRouter(actionBtn.type),
            contentDescription = "Icon",
            tint = Color.White,
            modifier = Modifier
                .semantics { contentDescription = "$actionBtn.type" }
        )

        if (actionBtn.hasFocus) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}
