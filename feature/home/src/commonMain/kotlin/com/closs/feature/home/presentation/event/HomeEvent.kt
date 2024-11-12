package com.closs.feature.home.presentation.event

sealed interface HomeEvent {
    data object ToggleAccountsMenu : HomeEvent
    data object OpenAccountDialog : HomeEvent
    data object DismissAccountDialog : HomeEvent
    data class OnSearchTextChange(val text: String) : HomeEvent
    data object OpenDrawer : HomeEvent
    data class ChangeAccount(val id: String) : HomeEvent
    data object AddAccount : HomeEvent
    data object SyncData : HomeEvent
    data object EndSession : HomeEvent
}
