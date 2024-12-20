package com.closs.dashboard.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.closs.core.presentation.components.display.CustomText
import com.closs.core.presentation.components.layout.LayoutComponent
import com.closs.core.presentation.navigation.event.home.HomeNavigationEvent
import com.closs.dashboard.presentation.viewmodel.DashboardViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = koinViewModel(),
    onNavigate: (HomeNavigationEvent) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LayoutComponent {
        CustomText(text = "hello")
    }
}
