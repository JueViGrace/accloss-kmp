package com.closs.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.closs.app.presentation.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AC-CLOSS",
    ) {
        App()
    }
}
