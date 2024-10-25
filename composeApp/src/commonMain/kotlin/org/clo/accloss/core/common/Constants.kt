package org.clo.accloss.core.common

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.an_unexpected_error_occurred
import ac_closs.composeapp.generated.resources.database_is_not_available
import ac_closs.composeapp.generated.resources.internal_server_error

object Constants {
    const val BASE_URL: String = "https://cloccidental.com"

    val SERVER_ERROR = Res.string.internal_server_error

    val DB_ERROR_MESSAGE = Res.string.database_is_not_available

    val UNEXPECTED_ERROR = Res.string.an_unexpected_error_occurred
}
