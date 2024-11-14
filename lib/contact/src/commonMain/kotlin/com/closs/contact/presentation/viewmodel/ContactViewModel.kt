package com.closs.contact.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.closs.core.types.common.Constants.CONTACTS_QUERY_KEY
import com.closs.core.types.common.Constants.SHARING_STARTED
import com.closs.core.types.data.RequestState
import com.closs.contact.domain.usecase.GetContacts
import com.closs.contact.presentation.state.ContactsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ContactViewModel(
    handle: SavedStateHandle,
    getContacts: GetContacts,
) : ViewModel() {
    private val contactsQuery = handle.getStateFlow(CONTACTS_QUERY_KEY, "")

    private val _state = MutableStateFlow(ContactsState())
    val state = combine(
        _state,
        contactsQuery,
        getContacts()
    ) { state, query, result ->
        when (result) {
            is RequestState.Success -> {
                if (query.isBlank()) {
                    state.copy(
                        salesmen = result,
                    )
                } else {
                    val data = result.data.filter { salesman ->
                        salesman.nombre.lowercase().contains(query.trim().lowercase()) ||
                            salesman.vendedor.lowercase().contains(query.trim().lowercase())
                    }

                    state.copy(
                        salesmen = RequestState.Success(data)
                    )
                }
            }
            else -> {
                state.copy(
                    salesmen = result,
                )
            }
        }
    }.stateIn(
        viewModelScope,
        SHARING_STARTED,
        ContactsState()
    )
}
