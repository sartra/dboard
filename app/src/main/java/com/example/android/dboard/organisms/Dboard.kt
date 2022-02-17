package com.example.android.dboard.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.molecules.DboardRow
import com.example.android.dboard.molecules.SearchInput
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.DboardButtonType.*
import com.example.android.dboard.ui.DboardButtonType.Char
import com.example.android.dboard.ui.theme.DPlusTheme

@Composable
fun Dboard(model: DboardModel) {
    val input = remember { mutableStateOf("") }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.TopStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.surface)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .background(color = MaterialTheme.colors.onSecondary, shape = RoundedCornerShape(5.dp))
                        .height(52.dp)

                ) {
                    SearchInput(input.value)
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxWidth(0.28F)
                        .padding(16.dp)
                ) {
                    val deleteButton = DboardButtonModel(type = Delete, callback = {
                        handleButtonClick(dBoardButtonType = Delete, inputTextView = input)
                    }, hasFocus = false)
                    val backSpaceButton = DboardButtonModel(type = BackSpace, callback = {
                        handleButtonClick(dBoardButtonType = BackSpace, inputTextView = input)
                    }, hasFocus = true)
                    DboardRow(buttons = listOf(deleteButton, backSpaceButton), false)

                    // loop through a-z, 0-9
                    val buttonsRow = mutableListOf<DboardButtonModel>()
                    for ((i, value) in model.keys.withIndex()) {

                        val button = DboardButtonModel(type = Char, char = value, callback = {
                            handleButtonClick(value.toString(), Char, input)
                        }, hasFocus = i == 0) // make a be in focus (it should be index 0 to accommodate other languages, not based on the char)

                        buttonsRow.add(button)

                        if ((i + 1) % 6 == 0 && i > 0) {
                            DboardRow(buttons = buttonsRow, false)
                            buttonsRow.clear()
                        }
                    }
                    val spaceBarButton = DboardButtonModel(type = Space, callback = {
                        handleButtonClick(dBoardButtonType = Space, inputTextView = input)
                    }, hasFocus = false)
                    DboardRow(buttons = listOf(spaceBarButton), false)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
}

fun handleButtonClick(
    txt: String? = "",
    dBoardButtonType: DboardButtonType,
    inputTextView: MutableState<String>
) {
    dBoardButtonType.let { type ->
        when (type) {
            BackSpace -> inputTextView.value = inputTextView.value.dropLast(1)
            Delete -> inputTextView.value = ""
            Space -> inputTextView.value += " "
            Char -> inputTextView.value += txt
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DboardPreview() {
    DPlusTheme {
        Dboard(
            DboardModel(
                language = "en",
                keys = "abcdefghijklmnopqrstuvwxyz1234567890".toList(),
                hasVoiceInput = false
            )
        )
    }
}