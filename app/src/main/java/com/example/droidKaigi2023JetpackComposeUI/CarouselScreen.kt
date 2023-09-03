package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselScreen() {
    Column(
        modifier = Modifier.padding(
            vertical = 8.dp
        )
    ) {
        Text(
            text = "Carousel Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(
                horizontal = 8.dp, vertical = 8.dp
            )
        )

        val pageCount = 5
        val pagerState = rememberPagerState(initialPage = 0)

        Column {
            HorizontalPager(
                state = pagerState,
                pageCount = pageCount,
                contentPadding = PaddingValues(24.dp),
                pageSpacing = 8.dp
            ) { page ->
                Box(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .height(240.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = page.toString(), fontSize = 48.sp)
                }
            }

            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(6.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)

                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarouselScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        CarouselScreen()
    }
}