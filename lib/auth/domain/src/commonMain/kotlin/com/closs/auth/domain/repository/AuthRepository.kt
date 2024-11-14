package com.closs.auth.domain.repository

import com.closs.core.types.data.RequestState
import com.closs.core.types.data.auth.Session
import com.closs.core.types.data.company.Company
import com.closs.core.types.data.user.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun fetchCompany(code: String): RequestState<Company>

    suspend fun login(baseUrl: String, username: String, password: String): RequestState<User>

    fun getCurrentUser(): Flow<RequestState<Session>>

    fun getSession(): Flow<RequestState<Session>>

    fun getSessions(): Flow<RequestState<List<Session>>>

    suspend fun addSession(session: Session)

    suspend fun updateSession(id: String)

    suspend fun deleteSession(session: Session)

    suspend fun endSession()
}
