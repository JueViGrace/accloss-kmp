package org.clo.accloss.config.data.remote.source

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import org.clo.accloss.config.data.remote.model.ConfigResponse
import org.clo.accloss.core.data.network.ApiOperation
import org.clo.accloss.core.data.network.KtorClient

class DefaultConfigRemoteSource(
    override val scope: CoroutineScope
) : ConfigRemoteSource {
    override suspend fun getRemoteConfiguration(
        baseUrl: String,
        salesman: String
    ): ApiOperation<ConfigResponse> = KtorClient.safeApiCall {
        KtorClient
            .client(
                baseUrl = baseUrl
            )
            .get(
                urlString = "/webservice/config_gen2.php?vendedor=$salesman"
            )
            .body<ConfigResponse>()
    }
}
