package org.clo.accloss.company.data.source

import org.clo.accloss.company.data.local.CompanyLocalSource
import org.clo.accloss.company.data.remote.source.CompanyRemoteSource
import org.clo.accloss.core.data.source.DataSource

class CompanyDataSource(
    override val localSource: CompanyLocalSource,
    override val remoteSource: CompanyRemoteSource
) : DataSource<CompanyLocalSource, CompanyRemoteSource>
