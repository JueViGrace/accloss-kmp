package org.clo.accloss.core.data.database

import app.cash.sqldelight.db.SqlDriver

expect class DriverFactory {
    suspend fun createDriver(): SqlDriver
}
