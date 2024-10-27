package org.clo.company.data.source

import org.clo.database.company.CompanyLocalSource
import org.clo.network.company.CompanyRemoteSource
import org.clo.types.core.DataSource

class CompanyDataSource(
    override val localSource: CompanyLocalSource,
    override val remoteSource: CompanyRemoteSource
) : DataSource<CompanyLocalSource, CompanyRemoteSource>
