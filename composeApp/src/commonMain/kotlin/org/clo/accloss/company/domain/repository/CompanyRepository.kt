package org.clo.accloss.company.domain.repository

import kotlinx.coroutines.flow.Flow
import org.clo.accloss.company.data.local.CompanyLocalSource
import org.clo.accloss.company.data.remote.source.CompanyRemoteSource
import org.clo.accloss.company.domain.model.Company
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.repository.Repository
import org.clo.accloss.core.domain.state.RequestState

interface CompanyRepository : Repository<DataSource<CompanyLocalSource, CompanyRemoteSource>> {
    fun getCompanies(): Flow<RequestState<List<Company>>>

    fun getCompany(code: String): Flow<RequestState<Company>>

    suspend fun addCompany(company: Company)

    suspend fun deleteCompany(company: String)
}
