package com.closs.types.common

import kotlinx.coroutines.flow.SharingStarted
import kotlin.time.Duration

object Constants {
    const val CLO: String = "081196"
    const val WOKIN: String = "753159"

    const val APP_VERSION: String = "1.0.0"

    const val BASE_URL: String = "https://cloccidental.com"

    const val UNKNOWN_ERROR = "Unknown error"

    const val SERVER_ERROR = "Internal server error"

    const val DB_ERROR_MESSAGE = "Database is not available"

    const val UNEXPECTED_ERROR = "Unexpected error"

    private val STOP_TIME_MILLIS = Duration.parse("2s").inWholeSeconds

    val SHARING_STARTED = SharingStarted.WhileSubscribed(STOP_TIME_MILLIS)
}
