package com.closs.contact.di

import com.closs.contact.domain.usecase.GetContacts
import com.closs.contact.presentation.viewmodel.ContactViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun contactModule(): Module = module {
    singleOf(::GetContacts)

    viewModelOf(::ContactViewModel)
}
