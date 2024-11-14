package com.closs.auth.domain.rules

import com.closs.core.types.data.ValidationError

object LoginValidator {

    fun validateErrors(username: String, password: String): LoginValidationError {
        var result = LoginValidationError()

        if (username.isBlank()) {
            result = result.copy(usernameError = ValidationError.EmptyError("Username must not be empty"))
        }

        if (password.isBlank()) {
            result = result.copy(passwordError = ValidationError.EmptyError("Password must not be empty"))
        }

        return result
    }

    data class LoginValidationError(
        val usernameError: ValidationError? = null,
        val passwordError: ValidationError? = null
    )
}
