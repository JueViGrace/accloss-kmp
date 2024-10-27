package org.clo.company.domain.repository

import kotlinx.coroutines.flow.Flow
import org.clo.database.company.CompanyLocalSource
import org.clo.network.company.CompanyRemoteSource
import org.clo.types.company.Company
import org.clo.types.core.DataSource
import org.clo.types.core.Repository
import org.clo.types.core.RequestState

interface CompanyRepository : Repository<DataSource<CompanyLocalSource, CompanyRemoteSource>> {
    fun getCompanies(): Flow<RequestState<List<Company>>>

    fun getCompany(code: String): Flow<RequestState<Company>>

    suspend fun addCompany(company: Company)

    suspend fun deleteCompany(company: String)
}
