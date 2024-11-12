package com.closs.feature.auth.presentation.navigation.graph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.closs.core.shared.presentation.navigation.event.auth.AuthNavigationEvent
import com.closs.core.shared.presentation.navigation.routes.Destinations
import com.closs.feature.auth.presentation.navigation.screen.AuthScreen

fun NavGraphBuilder.authGraph(
    navController: NavHostController
) {
    navigation<Destinations.AuthGraph>(
        startDestination = Destinations.Login,
    ) {
        composable<Destinations.Login>(
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            AuthScreen { event ->
                when (event) {
                    AuthNavigationEvent.OnHomeNavigate -> {
                        navController.navigate(Destinations.HomeGraph) {
                            popUpTo(Destinations.AuthGraph) {
                                inclusive = true
                            }

                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }
}
