package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@Composable
fun ShowMoreScreen() {
    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        Text(
            text = "ShowMore Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        /*
        ExpandableText(
            content = "吾輩は猫である。名前はまだ無い。どこで生れたかとんと見当がつかぬ。何でも薄暗いじめじめした所でニャーニャー泣いていた事だけは記憶している。吾輩はここで始めて人間というものを見た。しかもあとで聞くとそれは書生という人間中で一番獰悪な種族であったそうだ。この書生というのは時々我々を捕えて煮て食うという話である。しかしその当時は何という考もなかったから別段恐しいとも思わなかった。",
        )

         */

        ExpandableText(
            content = "吾輩は猫である。名前はまだ無い。どこで生れたかとんと見当がつかぬ。何でも薄暗いじめじめした所でニャーニャー泣いていた事だけは記憶している。吾輩はここで始めて人間というものを見た。しかもあとで聞くとそれは書生という人間中で一番獰悪な種族であったそうだ。この書生というのは時々我々を捕えて煮て食うという話である。しかしその当時は何という考もなかったから別段恐しいとも思わなかった。",
            threshold = LocalDensity.current.run { 96.dp.toPx() }
        )
    }
}

@Composable
fun ExpandableText(
    content: String
) {
    var expanded by remember { mutableStateOf(false) }

    Column() {
        Text(
            text = content,
            style = MaterialTheme.typography.displayMedium,
            maxLines = if (expanded) Int.MAX_VALUE else 3,
            modifier = Modifier.animateContentSize(),
        )
        if (!expanded) {
            Text(
                text = "もっと見る",
                style = MaterialTheme.typography.displayMedium,
                textDecoration = TextDecoration.Underline,
                color = Color.Magenta,
                modifier = Modifier.clickable {
                    expanded = true
                }
            )
        }
    }
}

@Composable
fun ExpandableText(
    content: String,
    threshold: Float,
) {

    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    var minimizedMaxLines by remember { mutableStateOf(Int.MAX_VALUE) }
    var expanded by remember { mutableStateOf(false) }
    val textLayoutResult = textLayoutResultState.value

    LaunchedEffect(content, expanded, textLayoutResult) {
        if (!expanded && textLayoutResult != null) {
            val lineCount = textLayoutResult.lineCount
            for (i in 0 until lineCount) {
                if (textLayoutResult.getLineBottom(i) > threshold) {
                    minimizedMaxLines = i
                    break
                }
            }
        }
    }

    Column() {
        Text(
            text = content,
            style = MaterialTheme.typography.displayMedium,
            maxLines = minimizedMaxLines,
            onTextLayout = { textLayoutResultState.value = it },
            modifier = Modifier.animateContentSize(),
        )
        if (!expanded && minimizedMaxLines != Int.MAX_VALUE) {
            Text(
                text = "もっと見る",
                style = MaterialTheme.typography.displayMedium,
                textDecoration = TextDecoration.Underline,
                color = Color.Magenta,
                modifier = Modifier.clickable {
                    expanded = true
                    minimizedMaxLines = Int.MAX_VALUE
                }
            )
        }
    }
}

@Composable
@Preview
fun ShowMoreScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        Surface(color = Color.White) {
            ExpandableText(
                content = """吾輩は猫である。名前はまだ無い。
                |どこで生れたかとんと見当がつかぬ。何でも薄暗いじめじめした所でニャーニャー泣いていた事だけは記憶している。
                |吾輩はここで始めて人間というものを見た。しかもあとで聞くとそれは書生という人間中で一番獰悪な種族であったそうだ。
                |この書生というのは時々我々を捕えて煮て食うという話である。しかしその当時は何という考もなかったから別段恐しいとも思わなかった。
                |ただ彼の掌に載せられてスーと持ち上げられた時何だかフワフワした感じがあったばかりである。
                """.trimMargin(),
                threshold = LocalDensity.current.run { 96.dp.toPx() }
            )
        }
    }
}