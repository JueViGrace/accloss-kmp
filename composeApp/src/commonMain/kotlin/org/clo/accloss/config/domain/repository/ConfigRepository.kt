package org.clo.accloss.config.domain.repository

import org.clo.accloss.config.data.local.ConfigLocalSource
import org.clo.accloss.config.data.remote.source.ConfigRemoteSource
import org.clo.accloss.config.domain.model.Config
import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.core.domain.repository.Repository
import org.clo.accloss.core.domain.state.RequestState

interface ConfigRepository : Repository<DataSource<ConfigLocalSource, ConfigRemoteSource>> {
    suspend fun getRemoteConfiguration(
        baseUrl: String,
        salesman: String,
        company: String
    ): RequestState<List<Config>>

    suspend fun getConfigNum(key: String, company: String): RequestState<Double>

    suspend fun getConfigBool(key: String, company: String): RequestState<Boolean>

    suspend fun getConfigText(key: String, company: String): RequestState<String>

    suspend fun getConfigDate(key: String, company: String): RequestState<String>

    suspend fun addConfiguration(configurations: List<Config>)

    suspend fun deleteConfiguration(company: String)
}
