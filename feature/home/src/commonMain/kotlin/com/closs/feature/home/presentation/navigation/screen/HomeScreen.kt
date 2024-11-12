package com.closs.feature.home.presentation.navigation.screen

import androidx.compose.runtime.Composable
import com.closs.core.shared.presentation.navigation.event.home.HomeNavigationEvent
import com.closs.feature.home.presentation.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigate: (HomeNavigationEvent) -> Unit
) {

}