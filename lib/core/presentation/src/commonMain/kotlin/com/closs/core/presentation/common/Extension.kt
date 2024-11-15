package com.closs.core.presentation.common

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.closs.core.presentation.navigation.routes.Destinations

fun NavHostController.navigateTo(route: Destinations) {
    return this.navigate(route = route) {
        popUpTo(this@navigateTo.graph.findStartDestination().id) {
            saveState = true
            inclusive = route == Destinations.HomeGraph || route == Destinations.AuthGraph
        }

        launchSingleTop = true
        restoreState = true
    }
}
