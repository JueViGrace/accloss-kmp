package org.clo.network.user

import org.clo.network.core.ApiOperation
import org.clo.types.core.RemoteSource
import org.clo.types.user.Estado
import org.clo.types.user.SyncBody

interface UserRemoteSource : RemoteSource {
    suspend fun synchronize(
        baseUrl: String,
        syncBody: SyncBody
    ): ApiOperation<Estado>
}
