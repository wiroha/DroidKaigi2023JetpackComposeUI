package com.example.droidKaigi2023JetpackComposeUI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroidKaigi2023JetpackComposeUITheme {
                AppNavigator()
            }
        }
    }
}

sealed class Screen(val route: String, val title: String) {
    object Home: Screen(route = "home_screen", "Main")
    object Indicator: Screen(route = "indicator_screen", "Indicator")
    object BottomNavigation: Screen(route = "bottom_navigatoin_screen", "BottomNavigation")
    object BottomSheet: Screen(route = "bottom_sheet_screen", "BottomSheet")
    object CreditCard: Screen(route = "credit_card_screen", "CreditCard")
    object Carousel: Screen(route = "carousel_screen", "Carousel")
    object Accordion: Screen(route = "accordion_screen", "Accordion")
    object StickyHeader: Screen(route = "sticky_header_screen", "StickyHeader")
    object ReadMore: Screen(route = "read_more_screen", "ReadMore")
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Indicator.route) { IndicatorScreen() }
        composable(Screen.BottomNavigation.route) { BottomNavigationScreen() }
        composable(Screen.BottomSheet.route) { BottomSheetScreen() }
        composable(Screen.CreditCard.route) { CreditCardScreen() }
        composable(Screen.Carousel.route) { CarouselScreen() }
        composable(Screen.Accordion.route) { AccordionScreen() }
        composable(Screen.StickyHeader.route) { StickyHeaderScreen() }
        composable(Screen.ReadMore.route) { ReadMoreScreen() }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        Greeting("Android")
    }
}