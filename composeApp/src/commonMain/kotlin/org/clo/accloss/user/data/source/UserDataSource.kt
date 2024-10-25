package org.clo.accloss.user.data.source

import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.user.data.local.UserLocalSource
import org.clo.accloss.user.data.remote.source.UserRemoteSource

class UserDataSource(
    override val localSource: UserLocalSource,
    override val remoteSource: UserRemoteSource
) : DataSource<UserLocalSource, UserRemoteSource>
