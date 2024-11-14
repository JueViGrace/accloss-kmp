package com.closs.home.presentation.state

import com.closs.core.types.data.RequestState
import com.closs.core.types.data.auth.Session

data class HomeState(
    val account: Session? = null,
    val accounts: List<Session> = emptyList(),
    val sync: RequestState<Boolean> = RequestState.Idle,
    val query: String = "",

    val showHomeDialog: Boolean = false,
    val showAccountsMenu: Boolean = false,
    val showAddAccountDialog: Boolean = false,
    val toggleDrawer: Boolean = false,

    val navigateToAuth: Boolean = false,
)
