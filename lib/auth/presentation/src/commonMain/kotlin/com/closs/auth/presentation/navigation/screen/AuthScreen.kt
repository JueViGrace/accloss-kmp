package com.closs.auth.presentation.navigation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.closs.auth.presentation.viewmodel.AuthViewModel
import com.closs.core.presentation.navigation.event.auth.AuthNavigationEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AuthScreen(
    viewModel: AuthViewModel = koinViewModel(),
    onNavigate: (AuthNavigationEvent) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
}
