package org.clo.accloss.user.data.remote.source

import org.clo.accloss.core.data.network.ApiOperation
import org.clo.accloss.core.data.source.RemoteSource
import org.clo.accloss.user.data.remote.model.Estado
import org.clo.accloss.user.data.remote.model.SyncBody

interface UserRemoteSource : RemoteSource {
    suspend fun synchronize(
        baseUrl: String,
        syncBody: SyncBody
    ): ApiOperation<Estado>
}
