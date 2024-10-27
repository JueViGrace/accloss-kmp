package org.clo.database.auth

import kotlinx.coroutines.flow.Flow
import org.clo.types.core.LocalSource
import org.clo.database.Session as SessionEntity

interface AuthLocalSource : LocalSource {
    suspend fun getCurrentUser(): Flow<SessionEntity?>

    suspend fun getCurrentSession(): SessionEntity?

    suspend fun getSessions(): List<SessionEntity>

    suspend fun addSession(session: SessionEntity)

    suspend fun updateSession(session: SessionEntity)

    suspend fun updateLastSync(lastSync: String, company: String)

    suspend fun deleteSession(session: SessionEntity)
}
