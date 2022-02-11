package com.example.android.dboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.model.DboardModel
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
                        .padding(16.dp)
                        .background(color = MaterialTheme.colors.onSecondary)
                        .height(60.dp)
                ) {
                    SearchInput(input.value)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .width(300.dp)
                        .padding(16.dp)
                ) {
                    val deleteButton = DboardButtonModel(type = Delete, callback = {
                        handleButtonClick(dBoardButtonType = Delete, inputTextView = input)
                    })
                    val backSpaceButton = DboardButtonModel(type = BackSpace, callback = {
                        handleButtonClick(dBoardButtonType = BackSpace, inputTextView = input)
                    })
                    DboardRow(buttons = listOf(deleteButton, backSpaceButton))

                    // loop through a-z, 0-9
                    val buttonsRow = mutableListOf<DboardButtonModel>()
                    for ((i, value) in model.keys.withIndex()) {
                        val button = DboardButtonModel(type = Char, char = value, callback = {
                            handleButtonClick(value.toString(), Char, input)
                        })
                        buttonsRow.add(button)
                        if ((i + 1) % 6 == 0 && i > 0) {
                            DboardRow(buttons = buttonsRow)
                            buttonsRow.clear()
                        }
                    }
                    val spaceBarButton = DboardButtonModel(type = Space, callback = {
                        handleButtonClick(dBoardButtonType = Space, inputTextView = input)
                    })
                    DboardRow(buttons = listOf(spaceBarButton))
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

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
                keys = "abcdefghijklmnopqrstuvwxyz0123456789".toList(),
                hasVoiceInput = false
            )
        )
    }
}
