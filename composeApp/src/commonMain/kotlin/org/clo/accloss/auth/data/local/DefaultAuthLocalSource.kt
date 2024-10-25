package org.clo.accloss.auth.data.local

import com.clo.accloss.Session
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import org.clo.accloss.core.data.database.DbHelper

class DefaultAuthLocalSource(
    override val scope: CoroutineScope,
    override val dbHelper: DbHelper
) : AuthLocalSource {
    override suspend fun getCurrentUser(): Flow<Session?> {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentSession(): Session? {
        TODO("Not yet implemented")
    }

    override suspend fun getSessions(): List<Session> {
        TODO("Not yet implemented")
    }

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
