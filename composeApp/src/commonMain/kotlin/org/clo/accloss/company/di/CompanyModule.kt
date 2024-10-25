package org.clo.accloss.company.di

import org.clo.accloss.company.data.local.CompanyLocalSource
import org.clo.accloss.company.data.local.DefaultCompanyLocalSource
import org.clo.accloss.company.data.remote.source.CompanyRemoteSource
import org.clo.accloss.company.data.remote.source.DefaultCompanyRemoteSource
import org.clo.accloss.company.data.repository.DefaultCompanyRepository
import org.clo.accloss.company.data.source.CompanyDataSource
import org.clo.accloss.company.domain.repository.CompanyRepository
import org.clo.accloss.core.data.source.DataSource
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun companyModule(): Module {
    return module {
        singleOf(::DefaultCompanyRemoteSource) bind CompanyRemoteSource::class

        singleOf(::DefaultCompanyLocalSource) bind CompanyLocalSource::class

        singleOf(::CompanyDataSource) bind DataSource::class

        singleOf(::DefaultCompanyRepository) bind CompanyRepository::class
    }
}
