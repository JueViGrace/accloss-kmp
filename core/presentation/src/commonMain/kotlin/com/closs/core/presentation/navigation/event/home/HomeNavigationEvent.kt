package com.closs.core.shared.presentation.navigation.event.home

import androidx.navigation.NavHostController
import com.closs.core.shared.presentation.navigation.routes.Destinations

sealed interface HomeNavigationEvent {
    data object OnBack : HomeNavigationEvent
    data object OnAuthNavigate : HomeNavigationEvent
    data class OnContactDetailNavigate(val id: String) : HomeNavigationEvent

    fun resolve(navController: NavHostController) {
        when (this) {
            OnAuthNavigate -> {
                navController.navigate(Destinations.AuthGraph) {
                    popUpTo(Destinations.HomeGraph) {
                        saveState = true
                    }

                    launchSingleTop = true
                }
            }
            is OnContactDetailNavigate -> {
                navController.navigate(Destinations.ContactDetail(this.id)) {
                    popUpTo(Destinations.Contacts) {
                        inclusive = false
                        saveState = true
                    }

                    launchSingleTop = true
                    restoreState = true
                }
            }
            OnBack -> {
                navController.popBackStack()
            }
        }
    }
}
