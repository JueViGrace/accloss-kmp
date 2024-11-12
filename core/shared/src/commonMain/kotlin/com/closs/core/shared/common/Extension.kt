package com.closs.core.shared.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.closs.core.shared.presentation.navigation.routes.Destinations
import kotlinx.datetime.LocalDateTime

fun Throwable.log(tag: String) =
    println(
        """
            $tag, 
            Message: ${this.message}\n
            Localized Message: ${this.localizedMessage}
        """.trimIndent()
    )

fun LocalDateTime.formatDate(): String {
    return "${this.date} ${this.time}"
}

@Composable
fun String.capitalizeString(): String {
    return this
        .lowercase()
        .split(" ")
        .joinToString(
            separator = " ",
            transform = { it.capitalize(Locale.current) }
        )
}

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
