package org.clo.network.config

import org.clo.network.core.ApiOperation
import org.clo.types.config.ConfigResponse
import org.clo.types.core.RemoteSource

interface ConfigRemoteSource : RemoteSource {
    suspend fun getRemoteConfiguration(
        baseUrl: String,
        salesman: String
    ): ApiOperation<ConfigResponse>
}
