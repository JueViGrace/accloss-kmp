package com.closs.feature.home.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.closs.shared.presentation.navigation.routes.Destinations
import com.closs.feature.home.presentation.navigation.screen.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController,
) {
    navigation<Destinations.HomeGraph>(
        startDestination = Destinations.Home,
    ) {
        composable<Destinations.Home> {
            HomeScreen { event ->
                event.resolve(navController)
            }
        }
    }
}
