package org.clo.accloss.config.data.source

import org.clo.accloss.config.data.local.ConfigLocalSource
import org.clo.accloss.config.data.remote.source.ConfigRemoteSource
import org.clo.accloss.core.data.source.DataSource

class ConfigDataSource(
    override val localSource: ConfigLocalSource,
    override val remoteSource: ConfigRemoteSource
) : DataSource<ConfigLocalSource, ConfigRemoteSource>
