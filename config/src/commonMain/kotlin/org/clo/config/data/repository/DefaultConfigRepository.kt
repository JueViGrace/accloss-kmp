package org.clo.config.data.repository

import kotlinx.coroutines.withContext
import org.clo.config.domain.mappers.toDatabase
import org.clo.config.domain.mappers.toDomain
import org.clo.config.domain.repository.ConfigRepository
import org.clo.database.config.ConfigLocalSource
import org.clo.network.config.ConfigRemoteSource
import org.clo.network.core.ApiOperation
import org.clo.types.common.Constants.DB_ERROR_MESSAGE
import org.clo.types.common.log
import org.clo.types.config.Config
import org.clo.types.core.DataSource
import org.clo.types.core.RequestState
import kotlin.coroutines.CoroutineContext

class DefaultConfigRepository(
    override val dataSource: DataSource<ConfigLocalSource, ConfigRemoteSource>,
    override val coroutineContext: CoroutineContext
) : ConfigRepository {
    override suspend fun getRemoteConfiguration(
        baseUrl: String,
        salesman: String,
        company: String,
    ): RequestState<List<Config>> {
        return withContext(coroutineContext) {
            val apiOperation = dataSource
                .remoteSource
                .getRemoteConfiguration(
                    baseUrl = baseUrl,
                    salesman = salesman
                )

            when (apiOperation) {
                is ApiOperation.Failure -> {
                    RequestState.Error(
                        message = apiOperation.error
                    )
                }
                is ApiOperation.Success -> {
                    val data = apiOperation.data.config.map { configurationItem ->
                        configurationItem
                            .toDomain()
                            .copy(
                                empresa = company
                            )
                    }

                    addConfiguration(data)

                    RequestState.Success(data = data)
                }
            }
        }
    }

    override suspend fun getConfigNum(key: String, company: String): RequestState<Double> {
        return try {
            RequestState.Success(
                data = dataSource
                    .localSource
                    .getConfigNum(
                        key = key,
                        company = company
                    )
            )
        } catch (e: Exception) {
            e.log("CONFIGURATION REPOSITORY: getConfigNum")
            RequestState.Error(message = DB_ERROR_MESSAGE)
        }
    }

    override suspend fun getConfigBool(key: String, company: String): RequestState<Boolean> {
        return try {
            val config = dataSource
                .localSource
                .getConfigBool(
                    key = key,
                    company = company
                )

            RequestState.Success(
                data = config == 1.0
            )
        } catch (e: Exception) {
            e.log("CONFIGURATION REPOSITORY: getConfigNum")
            RequestState.Error(message = DB_ERROR_MESSAGE)
        }
    }

    override suspend fun getConfigText(key: String, company: String): RequestState<String> {
        return try {
            RequestState.Success(
                data = dataSource
                    .localSource
                    .getConfigText(
                        key = key,
                        company = company
                    )
            )
        } catch (e: Exception) {
            e.log("CONFIGURATION REPOSITORY: getConfigNum")
            RequestState.Error(message = DB_ERROR_MESSAGE)
        }
    }

    override suspend fun getConfigDate(key: String, company: String): RequestState<String> {
        return try {
            RequestState.Success(
                data = dataSource
                    .localSource
                    .getConfigDate(
                        key = key,
                        company = company
                    )
            )
        } catch (e: Exception) {
            e.log("CONFIGURATION REPOSITORY: getConfigNum")
            RequestState.Error(message = DB_ERROR_MESSAGE)
        }
    }

    override suspend fun addConfiguration(configurations: List<Config>) {
        withContext(coroutineContext) {
            dataSource.localSource.addConfiguration(
                configurations.map { configuration ->
                    configuration.toDatabase()
                }
            )
        }
    }

    override suspend fun deleteConfiguration(company: String) {
        withContext(coroutineContext) {
            dataSource.localSource.deleteConfiguration(
                company = company
            )
        }
    }
}
