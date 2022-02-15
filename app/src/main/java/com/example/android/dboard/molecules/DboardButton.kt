package com.example.android.dboard.molecules

import android.view.KeyEvent.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.theme.BrandPrimary
import com.example.android.dboard.ui.theme.Neutral3

@Composable
fun DboardButton(
    model: DboardButtonModel,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester = FocusRequester(),

) {
    var buttonColor by remember { mutableStateOf(Neutral3) }
    Button(
        modifier = modifier
            .padding(2.dp)
            .defaultMinSize(38.dp, 38.dp)
            .clickable { focusRequester.requestFocus() }
            // The focusRequester should be added BEFORE the focusable.
            .focusRequester(focusRequester)
            // The onFocusChanged should be added BEFORE the focusable that is being observed.
            .onFocusChanged { buttonColor = if (it.isFocused) BrandPrimary else Neutral3 }
            .focusTarget()
            .focusable(true)
            .onKeyEvent {
                if (it.nativeKeyEvent.keyCode == KEYCODE_DPAD_CENTER ||
                    it.nativeKeyEvent.keyCode == KEYCODE_ENTER && it.nativeKeyEvent.action == ACTION_DOWN
                ) {
                    focusRequester.requestFocus()
                    model.callback()
                }
                false
            },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        onClick = {
            focusRequester.requestFocus()
            model.callback()
        }
    ) {

        when (model.type) {
            DboardButtonType.Char -> {
                Text(
                    textAlign = TextAlign.Center,
                    text = model.char.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                if (model.hasFocus) {
                    LaunchedEffect(Unit) {
                        focusRequester.requestFocus()
                    }
                }
            }
            DboardButtonType.BackSpace -> BackSpaceButton()
            DboardButtonType.Delete -> DeleteButton()
            DboardButtonType.Space -> SpaceBarButton()
        }
    }
}
