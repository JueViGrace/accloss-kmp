package org.clo.accloss.auth.data.source

import org.clo.accloss.auth.data.local.AuthLocalSource
import org.clo.accloss.auth.data.remote.AuthRemoteSource
import org.clo.accloss.core.data.source.DataSource

class AuthDataSource(
    override val localSource: AuthLocalSource,
    override val remoteSource: AuthRemoteSource
) : DataSource<AuthLocalSource, AuthRemoteSource>
