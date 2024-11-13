package com.closs.feature.auth.domain.repository

import com.closs.core.types.data.RequestState
import com.closs.core.types.data.company.Company
import com.closs.core.types.data.user.User

interface AuthRepository {
    fun fetchCompany(code: String): RequestState<Company>

    fun login(baseUrl: String, username: String, password: String): RequestState<User>

}
