package org.clo.accloss.user.data.repository

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.this_user_doesn_t_exists
import ac_closs.composeapp.generated.resources.you_have_an_outdated_version_please_update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.clo.accloss.core.common.Constants.DB_ERROR_MESSAGE
import org.clo.accloss.core.common.log
import org.clo.accloss.core.data.network.ApiOperation
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.state.RequestState
import org.clo.accloss.user.data.local.UserLocalSource
import org.clo.accloss.user.data.remote.model.Estado
import org.clo.accloss.user.data.remote.model.SyncBody
import org.clo.accloss.user.data.remote.model.Synchronization
import org.clo.accloss.user.data.remote.source.UserRemoteSource
import org.clo.accloss.user.domain.mappers.toDatabase
import org.clo.accloss.user.domain.mappers.toDomain
import org.clo.accloss.user.domain.model.User
import org.clo.accloss.user.domain.repository.UserRepository
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
                            message = Res.string.this_user_doesn_t_exists
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
                            message = Res.string.you_have_an_outdated_version_please_update
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
