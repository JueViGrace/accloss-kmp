package org.clo.accloss.auth.domain.repository

import kotlinx.coroutines.flow.Flow
import org.clo.accloss.auth.data.local.AuthLocalSource
import org.clo.accloss.auth.data.remote.AuthRemoteSource
import org.clo.accloss.auth.domain.model.Session
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.repository.Repository
import org.clo.accloss.core.domain.state.RequestState

interface AuthRepository : Repository<DataSource<AuthLocalSource, AuthRemoteSource>> {

    val getCurrentUser: Flow<RequestState<Session>>

    val getCurrentSession: Flow<RequestState<Session>>

    val getSessions: Flow<RequestState<List<Session>>>

    suspend fun addSession(session: Session)

    suspend fun updateSession(session: Session)

    suspend fun updateLastSync(lastSync: String, company: String)

    suspend fun deleteSession(session: Session)
}
