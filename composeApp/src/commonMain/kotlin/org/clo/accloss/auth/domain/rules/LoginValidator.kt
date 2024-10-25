package org.clo.accloss.auth.domain.rules

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.password_empty_error
import ac_closs.composeapp.generated.resources.username_empty_error
import org.jetbrains.compose.resources.StringResource

object LoginValidator {

    fun validateErrors(username: String, password: String): LoginValidationError {
        var result = LoginValidationError()

        if (username.isBlank()) {
            result = result.copy(usernameError = Res.string.username_empty_error)
        }

        if (password.isBlank()) {
            result = result.copy(passwordError = Res.string.password_empty_error)
        }

        return result
    }

    data class LoginValidationError(
        val usernameError: StringResource? = null,
        val passwordError: StringResource? = null
    )
}
