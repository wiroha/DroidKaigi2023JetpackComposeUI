package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselScreen() {
    Column(
        modifier = Modifier.padding(
            //horizontal = 8.dp, // このpaddingがあると左右のカードが切れる
            // Scaffoldを使っているパターンがあるのはこれを防ぐため？
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

        val state = rememberPagerState(initialPage = 0)
        //val animationScope = rememberCoroutineScope()
        Column {
            HorizontalPager(
                state = state,
                pageCount = 5,
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

            /*
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    animationScope.launch {
                        state.animateScrollToPage(state.currentPage + 1)
                    }
                }) {
                    Text(text = "Next Page")
                }
            }

             */
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberAutoScrollPagerState(
    interval: Long,
    initialPage: Int = 0,
): PagerState {
    val lifecycleOwner = LocalLifecycleOwner.current
    val pagerState = rememberPagerState(initialPage = initialPage)
    var refreshCount by remember { mutableStateOf(0) }
    val isScrolling = pagerState.isScrollInProgress

    LaunchedEffect(refreshCount) {  // ③
        runCatching {
            val target = pagerState.currentPage + 1
            pagerState.animateScrollToPage(
                //if (target >= pagerState.pageCount) {
                //    0
                //} else {
                target
                //}
            )
        }
    }
    LaunchedEffect(isScrolling) { // ①
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            if (!isScrolling) {
                delay(interval)
                refreshCount++  // ②
            }
        }
    }
    return pagerState
}

@Preview(showBackground = true)
@Composable
fun CarouselScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        CarouselScreen()
    }
}