package com.closs.feature.contact.presentation.events

sealed interface ContactsEvents {
    data class OnSearchTextChange(val text: String) : ContactsEvents
    data class OnContactClick(val id: String) : ContactsEvents
}
