package com.closs.app.di

import com.closs.core.presentation.navigation.DefaultNavigator
import com.closs.core.presentation.navigation.Navigator
import org.koin.core.module.Module
import org.koin.dsl.module

fun navigationModule(): Module = module {
    single<Navigator> {
        DefaultNavigator()
    }
}
