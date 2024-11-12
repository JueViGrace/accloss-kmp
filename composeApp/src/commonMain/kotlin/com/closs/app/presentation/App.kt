package com.closs.app.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.closs.app.presentation.navigation.Navigation
import com.closs.app.presentation.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        AppTheme(
            darkTheme = isSystemInDarkTheme(),
            dynamicColor = true
        ) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Navigation()
            }
        }
    }
}
