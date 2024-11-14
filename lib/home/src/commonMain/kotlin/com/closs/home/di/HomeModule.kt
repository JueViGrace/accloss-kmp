package com.closs.home.di

import com.closs.contact.detail.di.contactDetailModule
import com.closs.contact.di.contactModule
import com.closs.dashboard.di.dashboardModule
import com.closs.home.presentation.viewmodel.HomeViewModel
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
