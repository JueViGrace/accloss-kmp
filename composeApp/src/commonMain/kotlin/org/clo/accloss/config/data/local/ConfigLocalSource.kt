package org.clo.accloss.config.data.local

import org.clo.accloss.core.data.source.LocalSource
import com.clo.accloss.Configuration as ConfigEntity

interface ConfigLocalSource : LocalSource {
    suspend fun getConfigNum(key: String, company: String): Double

    suspend fun getConfigBool(key: String, company: String): Double?

    suspend fun getConfigText(key: String, company: String): String

    suspend fun getConfigDate(key: String, company: String): String

    suspend fun addConfiguration(configurations: List<ConfigEntity>)

    suspend fun deleteConfiguration(company: String)
}
