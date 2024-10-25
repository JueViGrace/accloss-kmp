package org.clo.accloss.company.domain.mappers

import org.clo.accloss.company.data.remote.model.CompanyResponse
import org.clo.accloss.company.domain.model.Company
import com.clo.accloss.Empresa as CompanyEntity

fun CompanyResponse.toDomain(): Company = Company(
    agenciaEmpresa = agenciaEmpresa ?: "",
    nombreEmpresa = nombreEmpresa ?: "",
    codigoEmpresa = codigoEmpresa ?: "",
    statusEmpresa = statusEmpresa ?: "",
    enlaceEmpresa = enlaceEmpresa ?: "",
    enlaceEmpresaPost = enlaceEmpresaPost ?: ""
)

fun CompanyEntity.toDomain(): Company = Company(
    agenciaEmpresa = agenciaEmpresa,
    nombreEmpresa = nombreEmpresa,
    codigoEmpresa = codigoEmpresa,
    statusEmpresa = statusEmpresa,
    enlaceEmpresa = enlaceEmpresa,
    enlaceEmpresaPost = enlaceEmpresaPost
)

fun Company.toDatabase(): CompanyEntity = CompanyEntity(
    agenciaEmpresa = agenciaEmpresa,
    nombreEmpresa = nombreEmpresa,
    codigoEmpresa = codigoEmpresa,
    statusEmpresa = statusEmpresa,
    enlaceEmpresa = enlaceEmpresa,
    enlaceEmpresaPost = enlaceEmpresaPost
)
