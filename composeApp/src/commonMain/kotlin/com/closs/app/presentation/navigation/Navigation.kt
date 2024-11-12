package com.closs.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.closs.core.shared.presentation.navigation.routes.Destinations
import com.closs.feature.auth.presentation.navigation.graph.authGraph
import com.closs.feature.home.presentation.navigation.graph.homeGraph

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.AuthGraph
    ) {
        authGraph(navController = navController)
        homeGraph(navController = navController)
    }
}
