package org.clo.auth.domain.rules

object LoginValidator {

    fun validateErrors(username: String, password: String): LoginValidationError {
        var result = LoginValidationError()

        if (username.isBlank()) {
            result = result.copy(usernameError = "Username must not be empty")
        }

        if (password.isBlank()) {
            result = result.copy(passwordError = "Password must not be empty")
        }

        return result
    }

    data class LoginValidationError(
        val usernameError: String? = null,
        val passwordError: String? = null
    )
}
