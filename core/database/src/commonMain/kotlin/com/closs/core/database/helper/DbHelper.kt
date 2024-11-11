package com.closs.core.database.helper

import com.closs.database.CloDb
import com.closs.core.database.driver.DriverFactory
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DbHelper(
    private val driver: DriverFactory,
) {
    private var db: CloDb? = null

    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: suspend (CloDb) -> Result): Result = mutex.withLock {
        if (db == null) {
            db = createDb()
        }

        return@withLock block(db!!)
    }

    private suspend fun createDb(): CloDb {
        return CloDb(driver = driver.createDriver())
    }
}
