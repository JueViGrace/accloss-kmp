package com.closs.types.common

enum class ErrorCode(val code: Int, val title: String) {
    BadRequest(400, "Bad request"),
    NotFound(404, "Not found"),
    ServerError(500, "Server error"),
    DatabaseError(501, "Database error"),
    NullError(502, "Null error"),
    VersionError(503, "Version error")
}
