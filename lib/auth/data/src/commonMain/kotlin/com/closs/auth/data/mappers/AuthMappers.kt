package com.closs.auth.data.mappers

import com.closs.core.types.data.auth.Session
import com.closs.core.types.data.company.Company
import com.closs.core.types.data.company.CompanyResponse
import com.closs.core.types.data.user.User
import com.closs.core.types.data.user.UserResponse
import com.closs.core.database.Session as SessionEntity

fun SessionEntity.toDomain(): Session = Session(
    id = id,
    nombre = nombre,
    nombreEmpresa = nombreEmpresa,
    user = user,
    empresa = empresa,
    enlaceEmpresa = enlaceEmpresa,
    enlaceEmpresaPost = enlaceEmpresaPost,
    active = active,
)

fun Session.toDatabase(): SessionEntity = SessionEntity(
    id = id,
    nombre = nombre,
    nombreEmpresa = nombreEmpresa,
    user = user,
    empresa = empresa,
    enlaceEmpresa = enlaceEmpresa,
    enlaceEmpresaPost = enlaceEmpresaPost,
    active = active,
)

fun UserResponse.toDomain(): User = User(
    almacen = almacen ?: "",
    correlativo = correlativo ?: "",
    correlativoreclamo = correlativoreclamo ?: "",
    desactivo = desactivo ?: 0.0,
    fechamodifi = fechamodifi ?: "",
    kcxCodven = kcxCodven ?: "",
    nombre = nombre ?: "",
    password = password ?: "",
    recibocobro = recibocobro ?: "",
    sesionactiva = sesionactiva ?: "",
    superves = superves ?: "",
    ualterprec = ualterprec ?: 0.0,
    username = username ?: "",
    ultSinc = ultSinc ?: "",
    vendedor = vendedor ?: ""
)

fun CompanyResponse.toDomain(): Company = Company(
    agenciaEmpresa = agenciaEmpresa ?: "",
    nombreEmpresa = nombreEmpresa ?: "",
    codigoEmpresa = codigoEmpresa ?: "",
    statusEmpresa = statusEmpresa ?: "",
    enlaceEmpresa = enlaceEmpresa ?: "",
    enlaceEmpresaPost = enlaceEmpresaPost ?: ""
)