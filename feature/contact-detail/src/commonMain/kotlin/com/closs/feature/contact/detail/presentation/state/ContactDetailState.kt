package com.closs.feature.contact.detail.presentation.state

import com.closs.shared.data.RequestState
import com.closs.shared.data.salesman.Salesman

data class ContactDetailState(
    val salesman: RequestState<Salesman> = RequestState.Loading
)
