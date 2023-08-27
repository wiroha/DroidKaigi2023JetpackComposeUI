package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val list = listOf(
            Screen.Indicator, Screen.BottomNavigation, Screen.BottomSheet, Screen.CreditCard,
            Screen.Carousel, Screen.Accordion, Screen.StickyHeader, Screen.ReadMore,
        )

        list.forEach { screen ->
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    navController.navigate(screen.route)
                }) {
                Text("Go to ${screen.title} Screen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navHostController = rememberNavController()
    DroidKaigi2023JetpackComposeUITheme {
        HomeScreen(navHostController)
    }
}