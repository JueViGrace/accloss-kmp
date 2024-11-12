package com.closs.core.types.common

import accloss_kmp.core.shared.generated.resources.Res
import accloss_kmp.core.shared.generated.resources.ic_avlogo
import accloss_kmp.core.shared.generated.resources.ic_wokin_logo
import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.SharingStarted
import org.jetbrains.compose.resources.painterResource
import kotlin.time.Duration

object Constants {
    const val CLO: String = "081196"
    const val WOKIN: String = "753159"

    const val CONTACTS_QUERY_KEY: String = "ContactsQueryKey"

    const val APP_VERSION: String = "1.0.0"

    const val BASE_URL: String = "https://cloccidental.com"

    const val UNKNOWN_ERROR = "Unknown error"

    const val SERVER_ERROR = "Internal server error"

    const val DB_ERROR_MESSAGE = "Database is not available"

    const val UNEXPECTED_ERROR = "Unexpected error"

    private val STOP_TIME_MILLIS = Duration.parse("5s").inWholeSeconds

    val SHARING_STARTED = SharingStarted.WhileSubscribed(STOP_TIME_MILLIS)

    @Composable
    fun selectAccountImage(company: String?) = when (company) {
        CLO -> painterResource(Res.drawable.ic_avlogo)
        WOKIN -> painterResource(Res.drawable.ic_wokin_logo)
        else -> painterResource(Res.drawable.ic_avlogo)
    }
}
