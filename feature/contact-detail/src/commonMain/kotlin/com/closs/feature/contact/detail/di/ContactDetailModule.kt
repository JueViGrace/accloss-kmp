package com.closs.feature.contact.detail.di

import com.closs.feature.contact.detail.domain.usecase.GetSalesman
import com.closs.feature.contact.detail.presentation.viewmodel.ContactDetailViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun contactDetailModule(): Module = module {
    singleOf(::GetSalesman)

    viewModelOf(::ContactDetailViewModel)
}
