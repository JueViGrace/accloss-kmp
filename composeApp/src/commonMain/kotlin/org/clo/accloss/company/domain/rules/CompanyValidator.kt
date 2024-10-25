package org.clo.accloss.company.domain.rules

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.company_empty_error
import ac_closs.composeapp.generated.resources.company_not_number_error
import org.jetbrains.compose.resources.StringResource

object CompanyValidator {
    fun validateErrors(company: String): CompanyValidationResult {
        var result = CompanyValidationResult()

        if (company.isEmpty()) {
            result = result.copy(companyError = Res.string.company_empty_error)
        } else if (company.map { it.isDigit() }.contains(false)) {
            result = result.copy(companyError = Res.string.company_not_number_error)
        }

        return result
    }

    data class CompanyValidationResult(
        val companyError: StringResource? = null
    )
}
