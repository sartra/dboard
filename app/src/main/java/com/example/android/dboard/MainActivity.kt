package com.example.android.dboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.android.dboard.model.DboardButtonModel
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.theme.DPlusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            setContent {
                DPlusTheme(
                    content = {
                        Scaffold(
                            topBar = {
                                TopAppBar(title = {
                                    Text(stringResource(id = R.string.search))
                                })
                            }
                        ) {
                            Dboard(
                                DboardModel(
                                    language = "en",
                                    keys = "abcdefghijklmnopqrstuvwxyz0123456789".toList(),
                                    hasVoiceInput = false
                                )
                            )
                        }
                    })
            }
        }
    }
}

@Composable
fun SearchInput(t: String) {
    val showHint = t.isEmpty()
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = if (showHint)
                stringResource(id = R.string.input_hint)
            else
                t,
            color = if (showHint)
                Color.Gray
            else
                MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4
        )
    }
}

@Preview
@Composable
fun SearchInputPreview() {
    SearchInput(t = "search input")
}

@Composable
fun DboardButton(
    model: DboardButtonModel,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .padding(4.dp),
        onClick = {
            model.callback
        }
    ) {
        Text(textAlign = TextAlign.Center, text = model.char.toString())
    }
}

fun handleButtonClick(
    txt: String,
    dBoardButtonType: DboardButtonType,
    inputTextView: MutableState<String>
) {

    inputTextView.value += txt

//    dBoardButtonType.let { type ->
//        when (type) {
//            DboardButtonType.Clear -> inputTextView.value = ""
//            DboardButtonType.Delete -> inputTextView.value.dropLast(1)
//            DboardButtonType.Space -> inputTextView.value += " "
//            else -> inputTextView.value += txt
//        }
//    }
}


@Composable
fun DboardRow(
    buttons: List<DboardButtonModel>,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in buttons) {
            DboardButton(
                i,
                modifier = Modifier.weight(1F)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DPlusTheme {
        SearchInput(t = "search input")
    }
}
