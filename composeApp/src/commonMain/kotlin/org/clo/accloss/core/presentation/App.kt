package org.clo.accloss.core.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.clo.accloss.core.presentation.theme.AppTheme
import org.clo.di.core.Koin.koinConfiguration
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        koinConfiguration()
    }) {
        AppTheme(
            darkTheme = isSystemInDarkTheme(),
            dynamicColor = true
        ) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {

            }
        }
    }
}
