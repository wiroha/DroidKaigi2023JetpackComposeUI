package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen() {
    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        val sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember { mutableStateOf(false) }

        Text(
            text = "BottomSheet Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(onClick = {
            showBottomSheet = true
        }) {
            Text(text = "Open BottomSheet", color = Color.White)
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                // ここにpaddingを入れるとシートの中身ではなく左右にpaddingが入った
                onDismissRequest = { showBottomSheet = false },
                // dragHandle = {},
                // shape = BottomSheetDefaults.HiddenShape,
                sheetState = sheetState,
            ) {
                // Sheet content
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "BottomSheet Content\nBottomSheet Content\nBottomSheet Content",
                    style = MaterialTheme.typography.displayMedium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        BottomSheetScreen()
    }
}