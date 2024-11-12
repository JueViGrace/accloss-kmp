package com.closs.core.shared.presentation.navigation.event.auth

sealed interface AuthNavigationEvent {
    data object OnHomeNavigate : AuthNavigationEvent
}
