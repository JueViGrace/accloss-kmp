package org.clo.accloss.auth.data.remote

import kotlinx.coroutines.CoroutineScope

class DefaultAuthRemoteSource(
    override val scope: CoroutineScope
) : AuthRemoteSource {
    override fun validateCompany(code: String) {
        TODO("Not yet implemented")
    }

    override fun login(baseUrl: String, username: String, password: String) {
        TODO("Not yet implemented")
    }
}
