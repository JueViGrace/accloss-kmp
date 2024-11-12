package com.closs.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.closs.app.di.appModule
import com.closs.app.presentation.App
import com.closs.core.di.KoinBuilder

fun main() = application {
    KoinBuilder.addModule(appModule()).build()
    Window(
        onCloseRequest = ::exitApplication,
        title = "AC-CLOSS",
    ) {
        App()
    }
}
