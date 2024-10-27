package org.clo.accloss

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.clo.accloss.core.presentation.App
import org.clo.di.core.Koin
import org.clo.di.desktopModule

fun main() = application {
    Koin.koinConfiguration(additionalModules = listOf(desktopModule))

    Window(
        onCloseRequest = ::exitApplication,
        title = "AC-CLOSS",
    ) {
        App()
    }
}
