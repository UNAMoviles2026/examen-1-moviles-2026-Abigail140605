package com.moviles.examenmoviles.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppNavUnselected
import com.moviles.examenmoviles.ui.theme.AppPrimary

@Composable
fun AppBottomBar() {
    NavigationBar(containerColor = AppBackground) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.nav_home)) },
            colors = navigationBarItemColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(imageVector = Icons.Outlined.BookmarkBorder, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.nav_reservations)) },
            colors = navigationBarItemColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(imageVector = Icons.Outlined.PersonOutline, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.nav_profile)) },
            colors = navigationBarItemColors()
        )
    }
}

@Composable
private fun navigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = AppPrimary,
    selectedTextColor = AppPrimary,
    unselectedIconColor = AppNavUnselected,
    unselectedTextColor = AppNavUnselected,
    indicatorColor = AppBackground
)

