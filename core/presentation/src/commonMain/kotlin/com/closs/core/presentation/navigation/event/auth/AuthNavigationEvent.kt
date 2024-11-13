package com.closs.core.presentation.navigation.event.auth

sealed interface AuthNavigationEvent {
    data object OnHomeNavigate : AuthNavigationEvent
}
