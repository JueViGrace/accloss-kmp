package org.clo.company.domain.rules

object CompanyValidator {
    fun validateErrors(company: String): CompanyValidationResult {
        var result = CompanyValidationResult()

        if (company.isEmpty()) {
            result = result.copy(companyError = "Company must not be empty")
        } else if (company.map { it.isDigit() }.contains(false)) {
            result = result.copy(companyError = "Company must be a number")
        }

        return result
    }

    data class CompanyValidationResult(
        val companyError: String? = null
    )
}
