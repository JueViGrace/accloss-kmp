package com.closs.app.common

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.closs.app.presentation.navigation.routes.Destinations
import com.closs.core.types.core.RequestState

@Composable
internal fun<T> RequestState<T>.DisplayResult(
    onIdle: (@Composable () -> Unit)? = null,
    onLoading: @Composable () -> Unit,
    onSuccess: @Composable (T) -> Unit,
    onError: @Composable (Int) -> Unit,
    transitionSpec: AnimatedContentTransitionScope<*>.() -> ContentTransform = {
        fadeIn(tween(durationMillis = 300)) togetherWith
            fadeOut(tween(durationMillis = 300))
    }
) {
    AnimatedContent(
        targetState = this,
        transitionSpec = transitionSpec,
        label = "Animated State"
    ) { state ->
        when (state) {
            is com.closs.core.types.core.RequestState.Idle -> {
                onIdle?.invoke()
            }

            is com.closs.core.types.core.RequestState.Loading -> {
                onLoading()
            }

            is com.closs.core.types.core.RequestState.Success -> {
                onSuccess(state.getSuccessData())
            }

            is com.closs.core.types.core.RequestState.Error -> {
                onError(state.getErrorMessage())
            }
        }
    }
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
            inclusive = true
        }

        launchSingleTop = true
        restoreState = true
    }
}
