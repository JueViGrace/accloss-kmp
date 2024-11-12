package com.closs.feature.contact.detail.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.closs.shared.presentation.components.buttons.BackArrowButton
import com.closs.shared.presentation.components.layout.LayoutComponent
import com.closs.shared.presentation.components.layout.TopBarActions
import com.closs.shared.presentation.components.layout.TopBarActionsComponent
import com.closs.shared.presentation.components.layout.TopBarComponent
import com.closs.shared.presentation.navigation.event.home.HomeNavigationEvent
import com.closs.feature.contact.detail.presentation.components.ContactComponent
import com.closs.feature.contact.detail.presentation.viewmodel.ContactDetailViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ContactDetailScreen(
    id: String,
    viewModel: ContactDetailViewModel = koinViewModel(parameters = { parametersOf(id) }),
    onNavigate: (HomeNavigationEvent) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LayoutComponent(
        topBar = {
            TopBarComponent(
                navigationIcon = {
                    BackArrowButton {
                        onNavigate(HomeNavigationEvent.OnBack)
                    }
                },
                actions = {
                    TopBarActionsComponent(
                        onMenuClick = { action ->
                            when (action) {
                                is TopBarActions.Statistics -> {
//                                        navigator.push(StatisticDetailsScreen(id))
                                }

                                is TopBarActions.Customers -> {
//                                        navigator.push(CustomersScreen(id))
                                }

                                is TopBarActions.Orders -> {
//                                        navigator.push(OrdersScreen(id))
                                }

                                is TopBarActions.Bills -> {
//                                        navigator.push(BillsScreen(id))
                                }

                                else -> {}
                            }
                        },
                        items = listOf(
                            TopBarActions.Statistics,
                            TopBarActions.Customers,
                            TopBarActions.Orders,
                            TopBarActions.Bills
                        )
                    )
                }
            )
        },
        state = state.salesman
    ) { salesman ->
        ContactComponent(
            salesman = salesman
        )
    }
}