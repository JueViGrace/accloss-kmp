package com.closs.auth.domain.usecase

import com.closs.auth.domain.repository.AuthRepository
import com.closs.core.types.data.RequestState
import com.closs.core.types.data.user.User
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FetchUser(
    private val authRepository: AuthRepository,
    private val coroutineContext: CoroutineContext
) {
    suspend operator fun invoke(
        baseUrl: String,
        username: String,
        password: String
    ): RequestState<User> {
        return withContext(coroutineContext) {
            authRepository.login(
                baseUrl = baseUrl,
                username = username,
                password = password
            )
        }
    }
}
