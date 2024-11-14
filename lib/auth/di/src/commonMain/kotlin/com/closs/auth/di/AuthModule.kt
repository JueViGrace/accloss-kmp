package com.closs.auth.di

import com.closs.auth.data.repository.AuthRepositoryImpl
import com.closs.auth.domain.repository.AuthRepository
import com.closs.auth.presentation.viewmodel.AuthViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun authModule(): Module = module {
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class

    viewModelOf(::AuthViewModel)
}
