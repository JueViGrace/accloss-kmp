package com.closs.core.database.di

import com.closs.core.database.driver.DriverFactory
import com.closs.core.database.helper.DbHelper
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun databaseModule(): Module = module {
    singleOf(::DriverFactory)

    singleOf(::DbHelper)
}