package org.clo.auth.domain.mappers

import org.clo.types.auth.Session
import org.clo.database.Session as SessionEntity

fun SessionEntity.toDomain(): Session = Session(
    nombre = nombre,
    nombreEmpresa = nombreEmpresa,
    user = user,
    empresa = empresa,
    enlaceEmpresa = enlaceEmpresa,
    enlaceEmpresaPost = enlaceEmpresaPost,
    active = active,
    lastSync = lastSync
)

fun Session.toDatabase(): SessionEntity = SessionEntity(
    nombre = nombre,
    nombreEmpresa = nombreEmpresa,
    user = user,
    empresa = empresa,
    enlaceEmpresa = enlaceEmpresa,
    enlaceEmpresaPost = enlaceEmpresaPost,
    active = active,
    lastSync = lastSync
)
