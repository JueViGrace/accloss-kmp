package org.clo.accloss.user.data.local

import kotlinx.coroutines.flow.Flow
import org.clo.accloss.core.data.source.LocalSource
import com.clo.accloss.User as UserEntity

interface UserLocalSource : LocalSource {
    suspend fun getUsers(): Flow<List<UserEntity>>

    suspend fun getUser(code: String, company: String): Flow<UserEntity?>

    suspend fun addUser(user: UserEntity)

    suspend fun updateSyncDate(lastSync: String, company: String)

    suspend fun deleteUser(user: String, company: String)
}
