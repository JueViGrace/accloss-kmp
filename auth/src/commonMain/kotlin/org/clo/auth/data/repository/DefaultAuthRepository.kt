package org.clo.auth.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.clo.auth.domain.repository.AuthRepository
import org.clo.database.auth.AuthLocalSource
import org.clo.network.auth.AuthRemoteSource
import org.clo.types.auth.Session
import org.clo.types.core.DataSource
import org.clo.types.core.RequestState
import kotlin.coroutines.CoroutineContext

class DefaultAuthRepository(
    override val dataSource: DataSource<AuthLocalSource, AuthRemoteSource>,
    override val coroutineContext: CoroutineContext,
) : AuthRepository {

    override val getCurrentUser: Flow<RequestState<Session>> = emptyFlow()

    override val getCurrentSession: Flow<RequestState<Session>> = emptyFlow()

    override val getSessions: Flow<RequestState<List<Session>>> = emptyFlow()

    override suspend fun addSession(session: Session) {
        TODO("Not yet implemented")
    }

    override suspend fun updateSession(session: Session) {
        TODO("Not yet implemented")
    }

    override suspend fun updateLastSync(lastSync: String, company: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSession(session: Session) {
        TODO("Not yet implemented")
    }
}
