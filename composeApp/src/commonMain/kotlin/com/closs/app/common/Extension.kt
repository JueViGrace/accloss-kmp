package com.closs.app.common

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import com.closs.core.types.core.RequestState

@Composable
internal fun<T> com.closs.core.types.core.RequestState<T>.DisplayResult(
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
