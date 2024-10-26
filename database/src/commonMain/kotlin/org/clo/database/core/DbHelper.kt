package org.clo.database.core

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.clo.database.CloDB

class DbHelper(
    private val driver: DriverFactory
) {
    private var db: CloDB? = null

    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: suspend (CloDB) -> Result): Result = mutex.withLock {
        if (db == null) {
            db = createDb()
        }

        return@withLock block(db!!)
    }

    private suspend fun createDb(): CloDB {
        return CloDB(driver = driver.createDriver())
    }
}
