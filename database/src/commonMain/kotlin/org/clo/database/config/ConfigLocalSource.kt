package org.clo.database.config

import org.clo.types.core.LocalSource
import org.clo.database.Configuration as ConfigEntity

interface ConfigLocalSource : LocalSource {
    suspend fun getConfigNum(key: String, company: String): Double

    suspend fun getConfigBool(key: String, company: String): Double?

    suspend fun getConfigText(key: String, company: String): String

    suspend fun getConfigDate(key: String, company: String): String

    suspend fun addConfiguration(configurations: List<ConfigEntity>)

    suspend fun deleteConfiguration(company: String)
}
