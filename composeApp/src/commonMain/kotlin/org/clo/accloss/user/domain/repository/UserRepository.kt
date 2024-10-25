package org.clo.accloss.user.domain.repository

import kotlinx.coroutines.flow.Flow
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.repository.Repository
import org.clo.accloss.core.domain.state.RequestState
import org.clo.accloss.user.data.local.UserLocalSource
import org.clo.accloss.user.data.remote.model.Estado
import org.clo.accloss.user.data.remote.model.Synchronization
import org.clo.accloss.user.data.remote.source.UserRemoteSource
import org.clo.accloss.user.domain.model.User

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
