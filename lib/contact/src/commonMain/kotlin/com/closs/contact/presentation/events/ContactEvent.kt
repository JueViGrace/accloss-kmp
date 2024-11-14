package com.closs.contact.presentation.events

sealed interface ContactsEvents {
    data class OnSearchTextChange(val text: String) : ContactsEvents
    data class OnContactClick(val id: String) : ContactsEvents
}
