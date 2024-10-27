package org.clo.network.config

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import org.clo.network.core.ApiOperation
import org.clo.network.core.KtorClient
import org.clo.types.config.ConfigResponse

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
