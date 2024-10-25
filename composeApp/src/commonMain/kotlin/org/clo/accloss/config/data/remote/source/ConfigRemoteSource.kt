package org.clo.accloss.config.data.remote.source

import org.clo.accloss.config.data.remote.model.ConfigResponse
import org.clo.accloss.core.data.network.ApiOperation
import org.clo.accloss.core.data.source.RemoteSource

interface ConfigRemoteSource : RemoteSource {
    suspend fun getRemoteConfiguration(
        baseUrl: String,
        salesman: String
    ): ApiOperation<ConfigResponse>
}
