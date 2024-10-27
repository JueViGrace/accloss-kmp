package org.clo.user.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.clo.database.user.UserLocalSource
import org.clo.network.core.ApiOperation
import org.clo.network.user.UserRemoteSource
import org.clo.types.common.Constants.DB_ERROR_MESSAGE
import org.clo.types.common.log
import org.clo.types.core.DataSource
import org.clo.types.core.RequestState
import org.clo.types.user.Estado
import org.clo.types.user.SyncBody
import org.clo.types.user.Synchronization
import org.clo.types.user.User
import org.clo.user.domain.mappers.toDatabase
import org.clo.user.domain.mappers.toDomain
import org.clo.user.domain.repository.UserRepository
import kotlin.coroutines.CoroutineContext

class DefaultUserRepository(
    override val dataSource: DataSource<UserLocalSource, UserRemoteSource>,
    override val coroutineContext: CoroutineContext,
) : UserRepository {
    override val getUsers: Flow<RequestState<List<User>>> = flow {
        emit(RequestState.Loading)

        dataSource.localSource.getUsers()
            .catch { e ->
                emit(
                    RequestState.Error(
                        message = DB_ERROR_MESSAGE
                    )
                )
                e.log("USER REPOSITORY: getUsers")
            }
            .collect { list ->
                emit(
                    RequestState.Success(
                        data = list.map { userEntity ->
                            userEntity.toDomain()
                        }
                    )
                )
            }
    }.flowOn(coroutineContext)

    override suspend fun getUser(code: String, company: String): Flow<RequestState<User>> = flow {
        emit(RequestState.Loading)

        dataSource.localSource.getUser(code = code, company = company)
            .catch { e ->
                emit(
                    RequestState.Error(
                        message = DB_ERROR_MESSAGE
                    )
                )
                e.log("PRODUCT REPOSITORY: getProducts")
            }
            .collect { userEntity ->
                if (userEntity != null) {
                    emit(
                        RequestState.Success(
                            data = userEntity.toDomain()
                        )
                    )
                } else {
                    emit(
                        RequestState.Error(
                            message = "User doesn't exists"
                        )
                    )
                }
            }
    }.flowOn(coroutineContext)

    override suspend fun addUser(user: User) {
        withContext(coroutineContext) {
            dataSource.localSource.addUser(user = user.toDatabase())
        }
    }

    override suspend fun updateSyncDate(lastSync: String, company: String) {
        withContext(coroutineContext) {
            dataSource.localSource.updateSyncDate(lastSync, company)
        }
    }

    override suspend fun synchronize(
        baseUrl: String,
        sync: Synchronization
    ): RequestState<Estado> {
        return withContext(coroutineContext) {
            when (
                val apiOperation = dataSource.remoteSource.synchronize(
                    baseUrl = baseUrl,
                    syncBody = SyncBody(sync)
                )
            ) {
                is ApiOperation.Failure -> {
                    RequestState.Error(message = apiOperation.error)
                }

                is ApiOperation.Success -> {
                    val data = apiOperation.data

                    if (data.response.status != 200) {
                        RequestState.Error(
                            message = "You have an outdated version, please update."
                        )
                    } else {
                        RequestState.Success(
                            data = data
                        )
                    }
                }
            }
        }
    }

    override suspend fun deleteUser(user: String, company: String) {
        withContext(coroutineContext) {
            dataSource.localSource.deleteUser(user = user, company = company)
        }
    }
}
