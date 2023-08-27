package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme

@Composable
fun BottomNavigationScreen() {
    Scaffold(
        bottomBar = { MyBottomNavigation() },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                text = "BottmNavigation Screen",
                style = MaterialTheme.typography.displayMedium,
                modifier =  Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
private fun MyBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = colors.surface,
    ) {
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        BottomNavigationScreen()
    }
}