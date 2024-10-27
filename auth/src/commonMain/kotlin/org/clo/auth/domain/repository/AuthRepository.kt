package org.clo.auth.domain.repository

import kotlinx.coroutines.flow.Flow
import org.clo.database.auth.AuthLocalSource
import org.clo.network.auth.AuthRemoteSource
import org.clo.types.auth.Session
import org.clo.types.core.DataSource
import org.clo.types.core.Repository
import org.clo.types.core.RequestState

interface AuthRepository : Repository<DataSource<AuthLocalSource, AuthRemoteSource>> {

    val getCurrentUser: Flow<RequestState<Session>>

    val getCurrentSession: Flow<RequestState<Session>>

    val getSessions: Flow<RequestState<List<Session>>>

    suspend fun addSession(session: Session)

    suspend fun updateSession(session: Session)

    suspend fun updateLastSync(lastSync: String, company: String)

    suspend fun deleteSession(session: Session)
}
