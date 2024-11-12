package com.closs.app.di

import com.closs.feature.auth.di.authModule
import com.closs.feature.home.di.homeModule
import org.koin.core.module.Module

fun appModule(): List<Module> = listOf(
    homeModule(),
    authModule(),
    stateModule(),
)
