package com.moviles.examenmoviles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.moviles.examenmoviles.ui.screens.CoworkingDetailScreen
import com.moviles.examenmoviles.ui.screens.CoworkingListScreen
import com.moviles.examenmoviles.ui.screens.CoworkingSpace
import com.moviles.examenmoviles.ui.theme.ExamenMovilesTheme

@Composable
fun CoworkingApp() {
    ExamenMovilesTheme {
        var selectedSpace by remember { mutableStateOf<CoworkingSpace?>(null) }

        if (selectedSpace == null) {
            CoworkingListScreen(
                onSpaceClick = { selectedSpace = it }
            )
        } else {
            CoworkingDetailScreen(
                space = selectedSpace!!,
                onBackClick = { selectedSpace = null },
                onReserveClick = { selectedSpace = null }
            )
        }
    }
}
