package com.example.droidKaigi2023JetpackComposeUI

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidKaigi2023JetpackComposeUI.ui.theme.DroidKaigi2023JetpackComposeUITheme
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderScreen() {
    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        Text(
            text = "StickyHeader Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier =  Modifier.padding(vertical = 8.dp)
        )

        // TODO: This ideally would be done in the ViewModel
        val grouped = members.groupBy { it.first() }

        LazyColumn {
            grouped.forEach { (initial, contactsForInitial) ->
                stickyHeader {
                    InitialHeader(initial)
                }
                items(contactsForInitial.size) { index ->
                    MemberListItem(contactsForInitial[index])
                }
            }
        }
    }
}

@Composable
fun InitialHeader(initial: Char) {
    Text(
        text = initial.toString(),
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MemberListItem(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier.padding(8.dp)
    )
}

val members = listOf(
    "Alice Johnson",
    "Arjun Kumar",
    "Amelia Johnson",
    "Alice Anderson",
    "Alan Arnold",
    "Anna Adams",
    "Benjamin O'Reilly",
    "Blake Nelson",
    "Bianca Rodriguez",
    "Bob Brown",
    "Bill Baker",
    "Betty Boop",
    "Charlie Brown",
    "Caleb Smith",
    "Chloe Kim",
    "Carlos Garcia",
    "Chris Carter",
    "David Doe",
    "Diana Duke",
    "Daniel Williams",
    "Daphne Brown",
    "Dylan Davis",
    "Dorothy Davis",
    "Eve Evans",
    "Eddie Edwards",
    "Elijah Wilson",
    "Ella Patel",
    "Eva Martinez",
    "Emily Elliot",
    "Frank Foster",
    "Fiona Fisher",
    "Finn Murphy",
    "Fiona Campbell",
    "Francis Thompson",
    "Fred Freeman",
    "Grace Lee",
    "Grace Hall",
    "Gavin Baker",
    "Gabriella Harris",
    "Grace Green",
    "George Grey",
    "Gloria Gold"
)

@Preview(showBackground = true)
@Composable
fun StickyHeaderrScreenPreview() {
    DroidKaigi2023JetpackComposeUITheme {
        StickyHeaderScreen()
    }
}