package com.example.android.dboard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.BackspaceCommand
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.ui.theme.DBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBoardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // Add DBoard
                }
            }
        }
    }
}

@Composable
fun SearchInput(t: String) {
    val showHint = t.isEmpty()
    Text(
        text = if (showHint)
            stringResource(id = R.string.input_hint)
        else
            t,
        color = if (showHint)
            MaterialTheme.colors.onSurface
        else
            MaterialTheme.colors.secondary,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun DboardRow(
    texts: List<String>,
    weights: List<Float>,
    callback: (text: String) -> Any
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in texts.indices) {
            DboardButton(
                text = texts[i],
                modifier = Modifier.weight(weights[i]),
                callback = callback
            )
        }
    }
}

@Composable
fun DboardButton(
    text: String,
    icon: Icon?,
    isBackspaceCommand: Boolean,
    isClear: Boolean,
    isMicrophone: Boolean,
    callback: (text: String) -> Any,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .padding(4.dp),
        onClick = {
            callback(text)
        }
    ) {
        Text(text)
    }
}

fun handleButtonClick(
    txt: String,
    inputTextView: MutableState<String>,
    outputTextView: MutableState<String>,
) {
    when (txt) {
        "" -> if (inputTextView.value.isNotEmpty()) {
            inputTextView.value = ""
        } else {
            outputTextView.value = ""
        }
        "+", "-", "=" -> handleInput(inputTextView, outputTextView, txt)
        ":" -> inputTextView.value += txt
        else -> inputTextView.value += txt
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DBoardTheme {
        SearchInput(t = "search input")
    }
}
