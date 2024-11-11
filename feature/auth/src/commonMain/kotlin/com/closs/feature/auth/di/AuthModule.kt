package com.closs.feature.auth.di

import com.closs.feature.auth.presentation.viewmodel.AuthViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun authModule(): Module = module {
    viewModelOf(::AuthViewModel)
}
