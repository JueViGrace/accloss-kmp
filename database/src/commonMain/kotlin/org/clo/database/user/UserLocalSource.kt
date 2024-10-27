package org.clo.database.user

import kotlinx.coroutines.flow.Flow
import org.clo.types.core.LocalSource
import org.clo.database.User as UserEntity

interface UserLocalSource : LocalSource {
    suspend fun getUsers(): Flow<List<UserEntity>>

    suspend fun getUser(code: String, company: String): Flow<UserEntity?>

    suspend fun addUser(user: UserEntity)

    suspend fun updateSyncDate(lastSync: String, company: String)

    suspend fun deleteUser(user: String, company: String)
}
