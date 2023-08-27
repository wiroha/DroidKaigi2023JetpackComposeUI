package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@Composable
fun CreditCardScreen() {
    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        Text(
            text = "CreditCard Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier =  Modifier.padding(vertical = 8.dp)
        )

        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = {
                if (it.length <= 16 && it.isDigitsOnly()) {
                    text = it
                }
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.displayLarge,
            visualTransformation = CreditCardNumberVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

class CreditCardNumberVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val output = buildString {
            text.forEachIndexed { index, char ->
                append(char)
                if (index % 4 == 3 && index < text.lastIndex) {
                    append('-')
                }
            }
        }

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int) =
                when (offset) {
                    in (1..4) -> offset
                    in (5..8) -> offset + 1
                    in (9..12) -> offset + 2
                    in (13..16) -> offset + 3
                    else -> offset
                }

            override fun transformedToOriginal(offset: Int) =
                when (offset) {
                    in (1..4) -> offset
                    in (5..9) -> offset - 1
                    in (11..14) -> offset - 2
                    in (15..19) -> offset - 3
                    else -> offset
                }
        }

        return TransformedText(
            text = AnnotatedString(output),
            offsetMapping = offsetMapping
        )
    }
}

class CreditCardNumberVisualTransformationForSlide : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = TODO("区切り文字を入れた変換後の文字列"),
            offsetMapping = object : OffsetMapping {
                override fun originalToTransformed(offset: kotlin.Int): Int {
                    TODO("入力文字列の位置から表示文字列の位置へのマッピング")
                }
                override fun transformedToOriginal(offset: kotlin.Int): Int {
                    TODO("表示文字列の位置から入力文字列の位置へのマッピング")
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CreditCardScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        CreditCardScreen()
    }
}