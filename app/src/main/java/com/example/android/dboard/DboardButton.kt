package com.example.android.dboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.theme.Neutral3

@Composable
fun DboardButton(
    model: DboardButtonModel,
    modifier: Modifier = Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Neutral3),
        modifier = modifier
            .padding(2.dp),
        onClick = model.callback
    ) {
        when (model.type) {
            DboardButtonType.Char -> {
                Text(
                    textAlign = TextAlign.Center,
                    text = model.char.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            DboardButtonType.BackSpace -> BackSpaceButton()
            DboardButtonType.Delete -> DeleteButton()
            DboardButtonType.Space -> SpaceBarButton()
        }
    }
}
