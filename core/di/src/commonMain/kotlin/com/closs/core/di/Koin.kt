package com.closs.core.di

import org.koin.core.context.GlobalContext.startKoin

// todo: maybe builder pattern?
object Koin {
    fun koinConfiguration() = startKoin {

    }
}