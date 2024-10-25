package org.clo.accloss.auth.domain.mappers

import org.clo.accloss.auth.domain.model.Session
import com.clo.accloss.Session as SessionEntity

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
