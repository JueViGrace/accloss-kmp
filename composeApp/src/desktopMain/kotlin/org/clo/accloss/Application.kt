package org.clo.accloss

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.clo.accloss.core.di.Koin
import org.clo.accloss.di.desktopModule
import org.clo.accloss.core.presentation.App

fun main() = application {
    Koin.koinConfiguration(additionalModules = listOf(desktopModule))

    Window(
        onCloseRequest = ::exitApplication,
        title = "AC-CLOSS",
    ) {
        App()
    }
}
