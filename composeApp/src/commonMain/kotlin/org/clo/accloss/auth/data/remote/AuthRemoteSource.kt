package org.clo.accloss.auth.data.remote

import org.clo.accloss.core.data.source.RemoteSource

interface AuthRemoteSource : RemoteSource {
    fun validateCompany(code: String)

    fun login(baseUrl: String, username: String, password: String)
}
