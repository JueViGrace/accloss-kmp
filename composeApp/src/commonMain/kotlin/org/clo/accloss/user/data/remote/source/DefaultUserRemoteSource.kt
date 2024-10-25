package org.clo.accloss.user.data.remote.source

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineScope
import org.clo.accloss.core.data.network.ApiOperation
import org.clo.accloss.core.data.network.KtorClient
import org.clo.accloss.user.data.remote.model.Estado
import org.clo.accloss.user.data.remote.model.SyncBody

class DefaultUserRemoteSource(
    override val scope: CoroutineScope
) : UserRemoteSource {
    override suspend fun synchronize(
        baseUrl: String,
        syncBody: SyncBody
    ): ApiOperation<Estado> = KtorClient.safeApiCall {
        KtorClient
            .client(
                baseUrl = baseUrl
            )
            .post(
                urlString = "/sincroonizacion",
                block = {
                    contentType(ContentType.Application.Json)
                    setBody(syncBody)
                }
            )
            .body<Estado>()
    }
}
