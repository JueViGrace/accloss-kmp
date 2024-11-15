package com.closs.core.types.data

import closs_kmp.lib.core.resources.generated.resources.Res
import closs_kmp.lib.core.resources.generated.resources.bad_request
import closs_kmp.lib.core.resources.generated.resources.database_error
import closs_kmp.lib.core.resources.generated.resources.internal_server_error
import closs_kmp.lib.core.resources.generated.resources.not_found
import closs_kmp.lib.core.resources.generated.resources.null_error
import closs_kmp.lib.core.resources.generated.resources.unexpected_error
import closs_kmp.lib.core.resources.generated.resources.unknown_error
import closs_kmp.lib.core.resources.generated.resources.version_error
import org.jetbrains.compose.resources.StringResource

sealed class DataError(val code: Int, val title: StringResource, val error: String? = null) {
    data class BadRequest(val message: String? = null) : DataError(
        code = 400,
        title = Res.string.bad_request,
        error = message
    )
    data class NotFound(val message: String? = null) : DataError(
        code = 404,
        title = Res.string.not_found,
        error = message
    )
    data class ServerDataError(val message: String? = null) : DataError(
        code = 500,
        title = Res.string.internal_server_error,
        error = message
    )
    data class DatabaseDataError(val message: String? = null) : DataError(
        code = 601,
        title = Res.string.database_error,
        error = message
    )
    data class NullDataError(val message: String? = null) : DataError(
        code = 602,
        title = Res.string.null_error,
        error = message
    )
    data class VersionDataError(val message: String? = null) : DataError(
        code = 603,
        title = Res.string.version_error,
        error = message
    )
    data class UnknownDataError(val message: String? = null) : DataError(
        code = 604,
        title = Res.string.unknown_error,
        error = message
    )
    data class UnexpectedDataError(val message: String? = null) : DataError(
        code = 604,
        title = Res.string.unexpected_error,
        error = message
    )
}
