package org.clo.accloss.company.data.local

import kotlinx.coroutines.flow.Flow
import org.clo.accloss.core.data.source.LocalSource
import com.clo.accloss.Empresa as CompanyEntity

interface CompanyLocalSource : LocalSource {

    suspend fun getCompanies(): Flow<List<CompanyEntity>>

    suspend fun getCompany(code: String): Flow<CompanyEntity?>

    suspend fun addCompany(company: CompanyEntity)

    suspend fun deleteCompany(company: String)
}
