package org.clo.database.company

import kotlinx.coroutines.flow.Flow
import org.clo.types.core.LocalSource
import org.clo.database.Empresa as CompanyEntity

interface CompanyLocalSource : LocalSource {
    suspend fun getCompanies(): Flow<List<CompanyEntity>>

    suspend fun getCompany(code: String): Flow<CompanyEntity?>

    suspend fun addCompany(company: CompanyEntity)

    suspend fun deleteCompany(company: String)
}
