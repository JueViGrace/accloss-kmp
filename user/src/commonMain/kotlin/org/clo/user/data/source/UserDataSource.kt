package org.clo.user.data.source

import org.clo.database.user.UserLocalSource
import org.clo.network.user.UserRemoteSource
import org.clo.types.core.DataSource

class UserDataSource(
    override val localSource: UserLocalSource,
    override val remoteSource: UserRemoteSource
) : DataSource<UserLocalSource, UserRemoteSource>
