package com.closs.feature.home.presentation.navigation.graph

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.closs.core.presentation.navigation.routes.Destinations
import com.closs.feature.contact.detail.presentation.screen.ContactDetailScreen
import com.closs.feature.contact.presentation.screen.ContactScreen
import com.closs.feature.dashboard.presentation.screen.DashboardScreen

@Composable
fun HomeNav(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.Dashboard
    ) {
        composable<Destinations.Dashboard> {
            DashboardScreen {
            }
        }

        composable<Destinations.Contacts> {
            ContactScreen { event ->
                event.resolve(navController)
            }
        }

        composable<Destinations.ContactDetail>(
            enterTransition = {
                fadeIn(animationSpec = tween(300, easing = LinearEasing))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(300, easing = EaseOut))
            }
        ) {
            val contactId = it.toRoute<Destinations.ContactDetail>()
            ContactDetailScreen(id = contactId.id) { event ->
                event.resolve(navController)
            }
        }

        composable<Destinations.Customers> {
        }

        composable<Destinations.CustomerDetail> {
        }

        composable<Destinations.Documents> {
        }

        composable<Destinations.DocumentDetail> {
        }

        composable<Destinations.Managers> {
        }

        composable<Destinations.Orders> {
        }

        composable<Destinations.OrderDetail> {
        }

        composable<Destinations.Products> {
        }

        composable<Destinations.ProductDetail> {
        }

        composable<Destinations.Statistics> {
        }
    }
}
