package org.clo.network.user

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineScope
import org.clo.network.core.ApiOperation
import org.clo.network.core.KtorClient
import org.clo.types.user.Estado
import org.clo.types.user.SyncBody

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
