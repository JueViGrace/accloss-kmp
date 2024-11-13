package com.closs.core.presentation.navigation.tabs

import accloss_kmp.core.resources.generated.resources.Res
import accloss_kmp.core.resources.generated.resources.contacts
import accloss_kmp.core.resources.generated.resources.customers
import accloss_kmp.core.resources.generated.resources.debts
import accloss_kmp.core.resources.generated.resources.home
import accloss_kmp.core.resources.generated.resources.ic_address_book
import accloss_kmp.core.resources.generated.resources.ic_buildings
import accloss_kmp.core.resources.generated.resources.ic_home
import accloss_kmp.core.resources.generated.resources.ic_receipt
import accloss_kmp.core.resources.generated.resources.ic_shopping_bag
import accloss_kmp.core.resources.generated.resources.ic_truck_delivery
import accloss_kmp.core.resources.generated.resources.ic_users_group
import accloss_kmp.core.resources.generated.resources.managements
import accloss_kmp.core.resources.generated.resources.orders
import accloss_kmp.core.resources.generated.resources.products
import com.closs.core.presentation.navigation.routes.Destinations
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class NavTabs(val title: StringResource, val icon: DrawableResource, val route: Destinations) {
    DASHBOARD(
        title = Res.string.home,
        icon = Res.drawable.ic_home,
        route = Destinations.Dashboard
    ),
    CONTACT(
        title = Res.string.contacts,
        icon = Res.drawable.ic_address_book,
        route = Destinations.Contacts
    ),
    CUSTOMERS(
        title = Res.string.customers,
        icon = Res.drawable.ic_users_group,
        route = Destinations.Customers
    ),
    DOCUMENTS(
        title = Res.string.debts,
        icon = Res.drawable.ic_receipt,
        route = Destinations.Documents
    ),
    MANAGERS(
        title = Res.string.managements,
        icon = Res.drawable.ic_buildings,
        route = Destinations.Managers
    ),
    ORDERS(
        title = Res.string.orders,
        icon = Res.drawable.ic_truck_delivery,
        route = Destinations.Orders
    ),
    PRODUCTS(
        title = Res.string.products,
        icon = Res.drawable.ic_shopping_bag,
        route = Destinations.Products
    )
}
