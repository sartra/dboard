package com.example.android.dboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
                            Dboard()
                        }
                    })
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
            Color.Gray
        else
            MaterialTheme.colors.primary,
        style = MaterialTheme.typography.h4
    )
}

@Preview
@Composable
fun SearchInputPreview() {
    SearchInput(t = "search input")
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
        Text(textAlign = TextAlign.Center, text = text)
    }
}

fun handleButtonClick(
    txt: String,
//    dBoardButtonType: DBoardButtonType,
    inputTextView: MutableState<String>
) {

    inputTextView.value += txt

//    dBoardButtonType.let { type ->
//        when (type) {
//            DBoardButtonType.CLEAR -> inputTextView.value = ""
//            DBoardButtonType.DELETE -> inputTextView.value.dropLast(1)
//            DBoardButtonType.SPACE -> inputTextView.value += " "
//            else -> inputTextView.value += txt
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DPlusTheme {
        SearchInput(t = "search input")
    }
}
