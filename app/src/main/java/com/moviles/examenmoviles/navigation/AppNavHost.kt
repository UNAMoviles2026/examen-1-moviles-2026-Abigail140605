package com.moviles.examenmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.data.mockCoworkingSpaces
import com.moviles.examenmoviles.ui.screens.CoworkingDetailScreen
import com.moviles.examenmoviles.ui.screens.CoworkingListScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.LIST,
        modifier = modifier
    ) {
        composable(route = AppDestinations.LIST) {
            CoworkingListScreen(
                spaces = mockCoworkingSpaces,
                selectedBottomRoute = AppDestinations.HOME,
                onBottomRouteClick = { },
                onSpaceClick = { space ->
                    navController.navigate("${AppDestinations.DETAIL}/${space.id}")
                }
            )
        }

        composable(
            route = "${AppDestinations.DETAIL}/{spaceId}",
            arguments = listOf(navArgument("spaceId") { type = NavType.StringType })
        ) { backStackEntry ->
            val spaceId = backStackEntry.arguments?.getString("spaceId")
            val selectedSpace = mockCoworkingSpaces.firstOrNull { it.id == spaceId }

            if (selectedSpace != null) {
                CoworkingDetailScreen(
                    space = selectedSpace,
                    selectedBottomRoute = AppDestinations.HOME,
                    onBottomRouteClick = { },
                    onBackClick = { navController.popBackStack() },
                    onReserveClick = { navController.popBackStack() }
                )
            }
        }
    }
}

