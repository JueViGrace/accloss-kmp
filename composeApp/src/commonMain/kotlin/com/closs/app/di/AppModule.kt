package com.closs.app.di

import com.closs.auth.di.authModule
import com.closs.home.di.homeModule
import org.koin.core.module.Module

fun appModule(): List<Module> = listOf(
    homeModule(),
    authModule(),
    stateModule(),
    navigationModule(),
)
