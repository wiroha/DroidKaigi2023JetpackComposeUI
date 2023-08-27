package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@Composable
fun IndicatorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        Text(
            text = "Default CircularProgressIndicator",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        CircularProgressIndicator()

        /*
        Text(
            text = "Custom CircularProgressIndicator",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row() {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(96.dp)
                    .width(96.dp)
                    .padding(12.dp),
                strokeWidth = 12.dp,
                trackColor = Color.LightGray,
            )

            CircularProgressIndicator(
                modifier = Modifier
                    .height(96.dp)
                    .width(96.dp)
                    .padding(12.dp),
                strokeWidth = 12.dp,
                color = Color.Red,
                strokeCap = StrokeCap.Butt
            )

            CircularProgressIndicator(
                modifier = Modifier
                    .height(96.dp)
                    .width(96.dp)
                    .padding(12.dp),
                strokeWidth = 12.dp,
                color = Color.Blue,
                trackColor = Color.LightGray,
                strokeCap = StrokeCap.Round
            )
        }

         */

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Default LinearProgressIndicator",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        LinearProgressIndicator()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "LinearProgressIndicator Increase",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        var progress by remember { mutableStateOf(0.1f) }
        val animatedProgress by animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        val progressPercent = (progress * 100).toInt()

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LinearProgressIndicator(
                progress = animatedProgress
            )
            Text(
                text = "Progress $progressPercent%",
                style = MaterialTheme.typography.labelSmall,
            )

            Spacer(Modifier.requiredHeight(30.dp))
            OutlinedButton(
                modifier = Modifier.semantics {
                    stateDescription = "Progress $progressPercent%"
                },
                onClick = {
                    if (progress < 1f) progress += 0.1f
                }
            ) {
                Text("Increase")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        BottomNavigationScreen()
    }
}