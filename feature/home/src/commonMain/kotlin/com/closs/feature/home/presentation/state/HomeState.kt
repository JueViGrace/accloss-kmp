package com.closs.feature.home.presentation.state

import com.closs.core.shared.data.RequestState

data class HomeState(
    val account: com.closs.core.shared.data.auth.Session? = null,
    val accounts: List<com.closs.core.shared.data.auth.Session> = emptyList(),
    val sync: RequestState<Boolean> = RequestState.Idle,
    val query: String = "",

    val showHomeDialog: Boolean = false,
    val showAccountsMenu: Boolean = false,
    val showAddAccountDialog: Boolean = false,
    val toggleDrawer: Boolean = false,

    val navigateToAuth: Boolean = false,
)
