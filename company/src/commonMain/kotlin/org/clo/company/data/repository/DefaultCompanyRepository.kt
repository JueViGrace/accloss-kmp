package org.clo.company.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.clo.company.domain.mappers.toDatabase
import org.clo.company.domain.mappers.toDomain
import org.clo.company.domain.repository.CompanyRepository
import org.clo.database.company.CompanyLocalSource
import org.clo.network.company.CompanyRemoteSource
import org.clo.types.common.Constants.DB_ERROR_MESSAGE
import org.clo.types.common.log
import org.clo.types.company.Company
import org.clo.types.core.DataSource
import org.clo.types.core.RequestState
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
                            message = "This company doesn't exists"
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
