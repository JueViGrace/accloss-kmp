package org.clo.accloss.di

import org.clo.accloss.core.data.database.DriverFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val desktopModule = module {
    singleOf(::DriverFactory)
}
