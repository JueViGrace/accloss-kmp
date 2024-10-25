package org.clo.accloss.config.data.local

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import org.clo.accloss.core.data.database.DbHelper
import com.clo.accloss.Configuration as ConfigEntity

class DefaultConfigLocalSource(
    override val scope: CoroutineScope,
    override val dbHelper: DbHelper
) : ConfigLocalSource {
    override suspend fun getConfigNum(key: String, company: String): Double {
        return scope.async {
            dbHelper.withDatabase { db ->
                db.configurationQueries
                    .getConfigNum(
                        key = key,
                        empresa = company
                    )
                    .executeAsOne()
            }
        }.await()
    }

    override suspend fun getConfigBool(key: String, company: String): Double? {
        return scope.async {
            dbHelper.withDatabase { db ->
                db.configurationQueries
                    .getConfigBool(
                        key = key,
                        empresa = company
                    )
                    .executeAsOneOrNull()
            }
        }.await()
    }

    override suspend fun getConfigText(key: String, company: String): String {
        return scope.async {
            dbHelper.withDatabase { db ->
                db.configurationQueries
                    .getConfigText(
                        key = key,
                        empresa = company
                    )
                    .executeAsOne()
            }
        }.await()
    }

    override suspend fun getConfigDate(key: String, company: String): String {
        return scope.async {
            dbHelper.withDatabase { db ->
                db.configurationQueries
                    .getConfigDate(
                        key = key,
                        empresa = company
                    )
                    .executeAsOne()
            }
        }.await()
    }

    override suspend fun addConfiguration(configurations: List<ConfigEntity>) {
        scope.async {
            dbHelper.withDatabase { db ->
                configurations.forEach { configuration ->
                    db.configurationQueries
                        .addConfiguration(
                            configuration = configuration
                        )
                }
            }
        }.await()
    }

    override suspend fun deleteConfiguration(company: String) {
        scope.async {
            dbHelper.withDatabase { db ->
                db.configurationQueries.deleteConfig(empresa = company)
            }
        }.await()
    }
}
