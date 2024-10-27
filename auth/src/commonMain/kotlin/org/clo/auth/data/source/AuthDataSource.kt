package org.clo.auth.data.source

import org.clo.database.auth.AuthLocalSource
import org.clo.network.auth.AuthRemoteSource
import org.clo.types.core.DataSource

class AuthDataSource(
    override val localSource: AuthLocalSource,
    override val remoteSource: AuthRemoteSource
) : DataSource<AuthLocalSource, AuthRemoteSource>
