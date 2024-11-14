package com.closs.auth.presentation.events

sealed interface AuthEvent {
    data class OnCompanyChanged(val value: String) : AuthEvent
    data object OnCompanyClicked : AuthEvent
    data class OnUsernameChanged(val value: String) : AuthEvent
    data class OnPasswordChanged(val value: String) : AuthEvent
    data class OnAccountSelected(val id: String) : AuthEvent
    data object OnLoginDismiss : AuthEvent
    data object OnLoginClicked : AuthEvent
    data object ToggleAuthMenu : AuthEvent
}