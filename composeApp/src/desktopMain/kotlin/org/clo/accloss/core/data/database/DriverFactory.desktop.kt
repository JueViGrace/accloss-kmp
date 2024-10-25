package org.clo.accloss.core.data.database

import app.cash.sqldelight.async.coroutines.awaitCreate
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.clo.accloss.CloDB

actual class DriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        CloDB.Schema.awaitCreate(driver)
        return driver
    }
}
