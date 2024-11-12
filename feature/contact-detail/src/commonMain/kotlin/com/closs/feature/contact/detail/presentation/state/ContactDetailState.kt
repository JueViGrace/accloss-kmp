package com.closs.feature.contact.detail.presentation.state

import com.closs.core.shared.data.RequestState
import com.closs.core.shared.data.salesman.Salesman

data class ContactDetailState(
    val salesman: RequestState<Salesman> = RequestState.Loading
)
