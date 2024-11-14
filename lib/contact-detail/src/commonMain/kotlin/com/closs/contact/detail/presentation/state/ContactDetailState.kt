package com.closs.contact.detail.presentation.state

import com.closs.core.types.data.RequestState
import com.closs.core.types.data.salesman.Salesman

data class ContactDetailState(
    val salesman: RequestState<Salesman> = RequestState.Loading
)
