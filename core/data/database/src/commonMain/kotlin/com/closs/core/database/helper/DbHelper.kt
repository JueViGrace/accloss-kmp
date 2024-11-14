package com.closs.core.database.helper

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.closs.core.database.CloDb
import com.closs.core.database.driver.DriverFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DbHelper(
    private val driver: DriverFactory,
    private val scope: CoroutineScope,
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

    suspend fun <T : Any> executeOne(query: Query<T>): T? {
        return scope.async {
            query.executeAsOneOrNull()
        }.await()
    }

    suspend fun <T : Any> executeOneAsFlow(query: Query<T>): Flow<T?> {
        return scope.async {
            query.asFlow().mapToOneOrNull(coroutineContext)
        }.await()
    }

    suspend fun <T : Any> excecuteList(query: Query<T>): List<T> {
        return scope.async {
            query.executeAsList()
        }.await()
    }

    suspend fun <T : Any> excecuteListAsFlow(query: Query<T>): Flow<List<T>> {
        return scope.async {
            query.asFlow().mapToList(coroutineContext)
        }.await()
    }
}
