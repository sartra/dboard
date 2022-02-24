package com.example.android.dboard.organisms

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.R
import com.example.android.dboard.model.ActionType
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.model.Key
import com.example.android.dboard.molecules.DboardRow
import com.example.android.dboard.molecules.SearchInput
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.DboardButtonType.*
import com.example.android.dboard.ui.DboardButtonType.Char
import com.example.android.dboard.ui.theme.DPlusTheme


@Composable
fun Dboard(model: DboardModel) {
   model.keys.forEach { row ->
       Column {
           row.forEach {
               Row {
                   KeyRouter(it)
               }
           }
       }
   }
}

@Composable
fun KeyRouter(key: Key) {
    when(key) {
        is Key.Character -> CharacterButton(key)
        is Key.Action -> ActionButton(key)
    }
}

@Composable
fun actionTypeIconRouter(actionType: ActionType): Painter {
    return when(actionType) {
        is ActionType.Backspace -> R.drawable.ic_backspace
        is ActionType.Delete ->  R.drawable.ic_delete
        is ActionType.Mic ->  R.drawable.ic_delete
        is ActionType.Spacebar -> R.drawable.ic_spacebar
    }.run {
        painterResource(this)
    }
}

@Composable
fun CharacterButton(character: Key.Character) {
    Button(onClick = { character.onClick(character.value) }) {
        Text(text = character.value)
    }
}

@Composable
fun ActionButton(action: Key.Action) {
    IconButton(onClick = { action.onClick(action.type) }) {
        Icon(painter = actionTypeIconRouter(action.type), contentDescription = "Icon")
    }
}

@Preview(showBackground = true)
@Composable
fun DboardPreview() {
    Dboard(
        DboardModel(
            listOf(
                listOf(Key.Action(ActionType.Delete, {}), Key.Action(ActionType.Backspace, {})),
                listOf(Key.Character("A", {}), Key.Character("B", {}), Key.Character("C", {})),
                listOf(Key.Character("D", {}), Key.Character("E", {}), Key.Character("F", {}))
            )
        )
    )
}

@Composable
fun Dboardz(model: DboardModel) {

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
                        .background(
                            color = MaterialTheme.colors.onSecondary,
                            shape = RoundedCornerShape(5.dp)
                        )
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
                    val deleteButton = DboardButtonModel(
                        type = Delete,
                        callback = { handleButtonClick(dBoardButtonType = Delete, inputTextView = input) },
                        hasFocus = false,
                        description = "dBoard_btn_delete"
                    )

                    val backSpaceButton = DboardButtonModel(
                        type = BackSpace,
                        callback = { handleButtonClick(dBoardButtonType = BackSpace, inputTextView = input) },
                        hasFocus = true,
                        description = "dBoard_btn_backspace"
                    )

                    DboardRow(buttons = listOf(deleteButton, backSpaceButton), false)

                    // loop through a-z, 0-9
                    val buttonsRow = mutableListOf<DboardButtonModel>()
                    for ((keyPosition, value) in model.keys.withIndex()) {

                        val description = "dBoard_btn_$keyPosition"
                        Log.d("dboard", description)

//                        val button = DboardButtonModel(
//                            type = Char,
//                            char = value,
//                            callback = {
//                                handleButtonClick(value.toString(), Char, input)
//                            },
//                            hasFocus = keyPosition == 0,  // make a be in focus (it should be index 0 to accommodate other languages, not based on the char)
//                            description = description
//                        )
//
//                        buttonsRow.add(button)

//                        if ((keyPosition + 1) % model.columns == 0 && keyPosition > 0) {
//                            DboardRow(buttons = buttonsRow, false)
//                            buttonsRow.clear()
//                        }
                    }
                    val spaceBarButton = DboardButtonModel(
                        type = Space,
                        description = "dBoard_btn_space",
                        callback = {
                            handleButtonClick(
                                dBoardButtonType = Space,
                                inputTextView = input
                            )
                        },
                        hasFocus = false
                    )

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

//@Preview(showBackground = true)
//@Composable
//fun DboardPreview() {
//    DPlusTheme {
//        Dboard(
//            DboardModel(
//                language = "en",
//                keys = "abcdefghijklmnopqrstuvwxyz1234567890".toList(),
//                hasVoiceInput = false,
//                columns = 6
//            )
//        )
//    }
//}
