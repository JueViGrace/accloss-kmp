package org.clo.company.domain.mappers

import org.clo.types.company.Company
import org.clo.types.company.CompanyResponse
import org.clo.database.Empresa as CompanyEntity

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
