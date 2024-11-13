package com.closs.core.presentation.navigation.routes

import kotlinx.serialization.Serializable

sealed interface Destinations {
    @Serializable
    data object AuthGraph : Destinations

    @Serializable
    data object Login : Destinations

    @Serializable
    data object HomeGraph : Destinations

    @Serializable
    data object Home : Destinations

    @Serializable
    data object Dashboard : Destinations

    @Serializable
    data object Managers : Destinations

    @Serializable
    data object Contacts : Destinations

    @Serializable
    data class ContactDetail(val id: String) : Destinations

    @Serializable
    data class Statistics(val id: String) : Destinations

    @Serializable
    data object Customers : Destinations

    @Serializable
    data class CustomerDetail(val id: String) : Destinations

    @Serializable
    data object Orders : Destinations

    @Serializable
    data class OrderDetail(val id: String) : Destinations

    @Serializable
    data object Documents : Destinations

    @Serializable
    data class DocumentDetail(val id: String) : Destinations

    @Serializable
    data object Products : Destinations

    @Serializable
    data class ProductDetail(val id: String) : Destinations
}
