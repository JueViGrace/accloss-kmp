package org.clo.accloss.core.data.database

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.clo.accloss.CloDB

actual class DriverFactory(
    private val context: Context
) {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CloDB.Schema.synchronous(), context, "clo.db")
    }
}
