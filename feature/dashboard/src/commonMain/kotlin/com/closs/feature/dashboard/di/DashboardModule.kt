package com.closs.feature.dashboard.di

import com.closs.feature.dashboard.presentation.viewmodel.DashboardViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun dashboardModule(): Module = module {
    viewModelOf(::DashboardViewModel)
}
