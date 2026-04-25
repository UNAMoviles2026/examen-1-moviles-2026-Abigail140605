package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.theme.AppIconTint
import com.moviles.examenmoviles.ui.theme.AppPrimary
import com.moviles.examenmoviles.ui.theme.AppSecondaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoworkingDetailScreen(
    space: CoworkingSpace,
    onBackClick: () -> Unit,
    onReserveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.detail_screen_title),
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = { AppBottomBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = space.name,
                style = MaterialTheme.typography.headlineLarge,
                color = AppPrimary
            )

            Text(
                text = space.description,
                style = MaterialTheme.typography.bodyLarge,
                color = AppSecondaryText
            )

            InfoRow(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = AppIconTint
                    )
                },
                label = stringResource(id = R.string.detail_location),
                value = space.location
            )

            InfoRow(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.People,
                        contentDescription = null,
                        tint = AppIconTint
                    )
                },
                label = stringResource(id = R.string.detail_capacity),
                value = "${space.capacity}"
            )

            InfoRow(
                icon = { Text(text = "$", color = AppIconTint) },
                label = stringResource(id = R.string.detail_price),
                value = "$${space.pricePerHour}/hour"
            )

            InfoRow(
                icon = { Text(text = "*", color = AppIconTint) },
                label = stringResource(id = R.string.detail_availability),
                value = if (space.isAvailable) {
                    stringResource(id = R.string.available)
                } else {
                    stringResource(id = R.string.not_available)
                }
            )

            Button(
                onClick = onReserveClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                enabled = space.isAvailable,
                colors = ButtonDefaults.buttonColors(containerColor = AppPrimary)
            ) {
                Text(text = stringResource(id = R.string.reserve_button))
            }
        }
    }
}

@Composable
private fun InfoRow(
    icon: @Composable () -> Unit,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = AppSecondaryText
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = AppPrimary
            )
        }
    }
}


