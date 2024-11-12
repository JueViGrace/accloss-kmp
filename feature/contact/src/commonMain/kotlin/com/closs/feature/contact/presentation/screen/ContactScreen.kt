package com.closs.feature.contact.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.closs.shared.presentation.components.layout.LayoutComponent
import com.closs.shared.presentation.navigation.event.home.HomeNavigationEvent
import com.closs.feature.contact.presentation.components.ContactsContent
import com.closs.feature.contact.presentation.viewmodel.ContactViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ContactScreen(
    viewModel: ContactViewModel = koinViewModel(),
    onNavigate: (HomeNavigationEvent) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LayoutComponent(
        state = state.salesmen,
    ) { salesmen ->
        ContactsContent(
            salesmen = salesmen,
            onSalesmanSelected = {
                onNavigate(HomeNavigationEvent.OnContactDetailNavigate(it))
            }
        )
    }
}
