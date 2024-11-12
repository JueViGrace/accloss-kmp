package com.closs.feature.home.di

import com.closs.feature.contact.detail.di.contactDetailModule
import com.closs.feature.contact.di.contactModule
import com.closs.feature.dashboard.di.dashboardModule
import com.closs.feature.home.presentation.viewmodel.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun homeModule(): Module = module {
    viewModelOf(::HomeViewModel)

    includes(
        contactModule(),
        contactDetailModule(),
        dashboardModule()
    )
}
