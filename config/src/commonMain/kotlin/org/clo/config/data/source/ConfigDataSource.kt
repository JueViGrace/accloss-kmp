package org.clo.config.data.source

import org.clo.database.config.ConfigLocalSource
import org.clo.network.config.ConfigRemoteSource
import org.clo.types.core.DataSource

class ConfigDataSource(
    override val localSource: ConfigLocalSource,
    override val remoteSource: ConfigRemoteSource
) : DataSource<ConfigLocalSource, ConfigRemoteSource>
