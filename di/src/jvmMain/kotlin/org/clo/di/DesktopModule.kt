package org.clo.di

import org.clo.database.core.DriverFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val desktopModule = module {
    singleOf(::DriverFactory)
}
