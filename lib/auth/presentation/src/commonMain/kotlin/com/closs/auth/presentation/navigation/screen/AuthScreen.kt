package com.closs.auth.presentation.navigation.screen

import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import com.closs.core.presentation.components.display.CustomText
import com.closs.core.presentation.navigation.event.auth.AuthNavigationEvent
import com.closs.auth.presentation.viewmodel.AuthViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AuthScreen(
    viewModel: AuthViewModel = koinViewModel(),
    onNavigate: (AuthNavigationEvent) -> Unit
) {
    // val state by viewModel.state.collectAsStateWithLifecycle()

    OutlinedButton(
        onClick = {
            onNavigate(AuthNavigationEvent.OnHomeNavigate)
        }
    ) {
        CustomText(text = "go home")
    }
}
