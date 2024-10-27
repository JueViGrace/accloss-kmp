package org.clo.network.auth

import org.clo.types.core.RemoteSource

interface AuthRemoteSource : RemoteSource {
    fun validateCompany(code: String)

    fun login(baseUrl: String, username: String, password: String)
}
