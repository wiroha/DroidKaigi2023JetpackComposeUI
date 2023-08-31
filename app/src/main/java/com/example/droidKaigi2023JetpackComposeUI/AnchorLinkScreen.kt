package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun AnchorLinkScreen() {
    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        Text(
            text = "AnchorLink Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        SmoothScrollToIdExample()
    }
}

@Composable
fun SmoothScrollToIdExample() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val positions = remember { mutableMapOf<String, Int>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "〇〇の方はStep 3へ",
            style = MaterialTheme.typography.displayLarge,
            textDecoration = TextDecoration.Underline,
            color = Color.Magenta,
            modifier = Modifier.clickable {
                positions["item3"]?.let { target ->
                    coroutineScope.launch {
                        scrollState.animateScrollTo(target)
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        for (i in 1..10) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .padding(bottom = 16.dp)
                    .onGloballyPositioned { coordinates ->
                        val position = coordinates.positionInParent().y.roundToInt()
                        positions["item$i"] = position
                    }
            ) {
                Text(
                    text = "Step $i\nxxxxxxxxxxx",
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnchorLinkScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        AnchorLinkScreen()
    }
}