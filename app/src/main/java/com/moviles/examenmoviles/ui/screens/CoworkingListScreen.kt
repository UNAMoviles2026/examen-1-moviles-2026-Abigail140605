package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.CoworkingSpaceCard

data class CoworkingSpace(
    val name: String,
    val description: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val isAvailable: Boolean
)

val mockCoworkingSpaces = listOf(
    CoworkingSpace(
        name = "North Hub Lounge",
        description = "Shared space with good internet and quiet work areas.",
        location = "Ciudad Quesada",
        capacity = 20,
        pricePerHour = 8.5,
        isAvailable = true
    ),
    CoworkingSpace(
        name = "Creative Room 2",
        description = "Comfortable room for team sessions and meetings.",
        location = "Guapiles",
        capacity = 10,
        pricePerHour = 11.0,
        isAvailable = false
    ),
    CoworkingSpace(
        name = "Focus Desk Zone",
        description = "Open desks for individual work with natural light.",
        location = "Puerto Viejo",
        capacity = 15,
        pricePerHour = 7.25,
        isAvailable = true
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoworkingListScreen(
    spaces: List<CoworkingSpace> = mockCoworkingSpaces,
    onSpaceClick: (CoworkingSpace) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.list_screen_title),
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = { AppBottomBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(spaces) { space ->
                CoworkingSpaceCard(
                    space = space,
                    onDetailsClick = { onSpaceClick(space) }
                )
            }
        }
    }
}
