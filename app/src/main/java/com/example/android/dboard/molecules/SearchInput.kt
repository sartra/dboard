package com.example.android.dboard.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.R
import com.example.android.dboard.ui.theme.DPlusTypography
import com.example.android.dboard.ui.theme.Neutral10
import com.example.android.dboard.ui.theme.Neutral6

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
                stringResource(id = R.string.search)
            else
                t,
            color = if (showHint)
                Neutral6
            else
                Neutral10,
            style = if (showHint)
                DPlusTypography.sectionExtraLargeLight
            else
                DPlusTypography.subTitleExtraLarge

        )
    }
}

@Preview
@Composable
fun SearchInputPreview() {
    SearchInput(t = "search")
}
