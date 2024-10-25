package org.clo.accloss.auth.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.clo.accloss.auth.data.local.AuthLocalSource
import org.clo.accloss.auth.data.remote.AuthRemoteSource
import org.clo.accloss.auth.domain.model.Session
import org.clo.accloss.auth.domain.repository.AuthRepository
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.state.RequestState
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
