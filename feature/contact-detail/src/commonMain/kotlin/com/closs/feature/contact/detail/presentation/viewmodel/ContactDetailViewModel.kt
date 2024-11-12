package com.closs.feature.contact.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.closs.shared.common.Constants.SHARING_STARTED
import com.closs.feature.contact.detail.domain.usecase.GetSalesman
import com.closs.feature.contact.detail.presentation.state.ContactDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ContactDetailViewModel(
    id: String,
    getSalesman: GetSalesman,
) : ViewModel() {
    private val _state = MutableStateFlow(ContactDetailState())
    val state = combine(
        _state,
        getSalesman(id)
    ) { state, salesman ->
        state.copy(
            salesman = salesman
        )
    }.stateIn(
        viewModelScope,
        SHARING_STARTED,
        ContactDetailState()
    )
}
