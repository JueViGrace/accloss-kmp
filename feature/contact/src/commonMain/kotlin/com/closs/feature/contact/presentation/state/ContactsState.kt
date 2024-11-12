package com.closs.feature.contact.presentation.state

import com.closs.core.shared.data.RequestState
import com.closs.core.shared.data.salesman.Salesman

data class ContactsState(
    val salesmen: RequestState<List<Salesman>> = RequestState.Loading,
    val reload: Boolean? = null,
)
