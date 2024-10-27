package org.clo.database.auth

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import org.clo.database.core.DbHelper
import org.clo.database.Session as SessionEntity

class DefaultAuthLocalSource(
    override val scope: CoroutineScope,
    private val dbHelper: DbHelper
) : AuthLocalSource {
    override suspend fun getCurrentUser(): Flow<SessionEntity?> {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentSession(): SessionEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getSessions(): List<SessionEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun addSession(session: SessionEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateSession(session: SessionEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateLastSync(lastSync: String, company: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSession(session: SessionEntity) {
        TODO("Not yet implemented")
    }
}
