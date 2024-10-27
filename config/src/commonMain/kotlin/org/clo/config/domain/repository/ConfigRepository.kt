package org.clo.config.domain.repository

import org.clo.database.config.ConfigLocalSource
import org.clo.network.config.ConfigRemoteSource
import org.clo.types.config.Config
import org.clo.types.core.DataSource
import org.clo.types.core.Repository
import org.clo.types.core.RequestState

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
