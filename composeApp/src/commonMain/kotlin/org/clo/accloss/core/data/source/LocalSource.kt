package org.clo.accloss.core.data.source

import kotlinx.coroutines.CoroutineScope
import org.clo.accloss.core.data.database.DbHelper

interface LocalSource {
    val scope: CoroutineScope
    val dbHelper: DbHelper
}
