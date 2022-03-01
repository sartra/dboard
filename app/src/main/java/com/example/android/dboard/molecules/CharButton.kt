package com.example.android.dboard.molecules

import android.view.KeyEvent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.dboard.model.Key
import com.example.android.dboard.ui.theme.BrandPrimary
import com.example.android.dboard.ui.theme.Neutral3

@Composable
fun CharButton(char: Key.Char, focusRequester: FocusRequester = FocusRequester()) {
    var buttonColor by remember { mutableStateOf(Neutral3) }
    Button(
        modifier = Modifier
            .size(width = 60.dp,height = 50.dp)
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
            char.onClick(char.value)
            focusRequester.requestFocus()
        }
    ) {
        Text(
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            text = char.value,
            modifier = Modifier
                .semantics { contentDescription = char.toString() })
        if (char.hasFocus) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}
