package com.closs.feature.contact.presentation.state

import com.closs.core.types.data.RequestState
import com.closs.core.types.data.salesman.Salesman

data class ContactsState(
    val salesmen: RequestState<List<Salesman>> = RequestState.Loading,
    val reload: Boolean? = null,
)
