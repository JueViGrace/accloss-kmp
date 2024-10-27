package org.clo.user.domain.repository

import kotlinx.coroutines.flow.Flow
import org.clo.database.user.UserLocalSource
import org.clo.network.user.UserRemoteSource
import org.clo.types.core.DataSource
import org.clo.types.core.Repository
import org.clo.types.core.RequestState
import org.clo.types.user.Estado
import org.clo.types.user.Synchronization
import org.clo.types.user.User

interface UserRepository : Repository<DataSource<UserLocalSource, UserRemoteSource>> {
    val getUsers: Flow<RequestState<List<User>>>

    suspend fun getUser(code: String, company: String): Flow<RequestState<User>>

    suspend fun addUser(user: User)

    suspend fun updateSyncDate(lastSync: String, company: String)

    suspend fun synchronize(
        baseUrl: String,
        sync: Synchronization
    ): RequestState<Estado>

    suspend fun deleteUser(user: String, company: String)
}
