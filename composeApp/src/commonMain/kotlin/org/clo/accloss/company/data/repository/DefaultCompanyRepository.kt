package org.clo.accloss.company.data.repository

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.this_company_doesn_t_exists
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.clo.accloss.company.data.local.CompanyLocalSource
import org.clo.accloss.company.data.remote.source.CompanyRemoteSource
import org.clo.accloss.company.domain.mappers.toDatabase
import org.clo.accloss.company.domain.mappers.toDomain
import org.clo.accloss.company.domain.model.Company
import org.clo.accloss.company.domain.repository.CompanyRepository
import org.clo.accloss.core.common.Constants.DB_ERROR_MESSAGE
import org.clo.accloss.core.common.log
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.state.RequestState
import kotlin.coroutines.CoroutineContext

class DefaultCompanyRepository(
    override val dataSource: DataSource<CompanyLocalSource, CompanyRemoteSource>,
    override val coroutineContext: CoroutineContext
) : CompanyRepository {
    override fun getCompanies(): Flow<RequestState<List<Company>>> = flow {
        emit(RequestState.Loading)

        dataSource.localSource
            .getCompanies()
            .catch { e ->
                emit(
                    RequestState.Error(
                        message = DB_ERROR_MESSAGE
                    )
                )
                e.log("COMPANY REPOSITORY: getCompanies")
            }
            .collect { cachedList ->
                emit(
                    RequestState.Success(
                        data = cachedList.map { companyEntity ->
                            companyEntity.toDomain()
                        }
                    )
                )
            }
    }.flowOn(coroutineContext)

    override fun getCompany(code: String): Flow<RequestState<Company>> = flow {
        emit(RequestState.Loading)

        dataSource.localSource.getCompany(code = code)
            .catch { e ->
                emit(
                    RequestState.Error(
                        message = DB_ERROR_MESSAGE
                    )
                )
                e.log("COMPANY REPOSITORY: getCompany")
            }
            .collect { companyEntity ->
                if (companyEntity != null) {
                    emit(
                        RequestState.Success(data = companyEntity.toDomain())
                    )
                } else {
                    emit(
                        RequestState.Error(
                            message = Res.string.this_company_doesn_t_exists
                        )
                    )
                }
            }
    }.flowOn(coroutineContext)

    override suspend fun addCompany(company: Company) {
        withContext(coroutineContext) {
            dataSource.localSource
                .addCompany(
                    company = company.toDatabase()
                )
        }
    }

    override suspend fun deleteCompany(company: String) {
        withContext(coroutineContext) {
            dataSource.localSource
                .deleteCompany(
                    company = company
                )
        }
    }
}
