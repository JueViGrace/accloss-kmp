package org.clo.config.domain.mappers

import org.clo.types.config.Config
import org.clo.types.config.ConfigItem
import org.clo.database.Configuration as ConfigurationEntity

fun ConfigurationEntity.toDomain(): Config = Config(
    cnfgActiva = cnfgActiva,
    cnfgClase = cnfgClase,
    cnfgEtiq = cnfgEtiq,
    cnfgIdconfig = cnfgIdconfig,
    cnfgLentxt = cnfgLentxt,
    cnfgTipo = cnfgTipo,
    cnfgTtip = cnfgTtip,
    cnfgValfch = cnfgValfch,
    cnfgValnum = cnfgValnum,
    cnfgValsino = cnfgValsino,
    cnfgValtxt = cnfgValtxt,
    fechamodifi = fechamodifi,
    username = username,
    empresa = empresa,
)

fun ConfigItem.toDomain(): Config = Config(
    cnfgActiva = cnfgActiva ?: 0.0,
    cnfgClase = cnfgClase ?: "",
    cnfgEtiq = cnfgEtiq ?: "",
    cnfgIdconfig = cnfgIdconfig ?: "",
    cnfgLentxt = cnfgLentxt ?: 0.0,
    cnfgTipo = cnfgTipo ?: "",
    cnfgTtip = cnfgTtip ?: "",
    cnfgValfch = cnfgValfch ?: "",
    cnfgValnum = cnfgValnum ?: 0.0,
    cnfgValsino = cnfgValsino ?: 0.0,
    cnfgValtxt = cnfgValtxt ?: "",
    fechamodifi = fechamodifi ?: "",
    username = username ?: "",
    empresa = empresa ?: "",
)

fun Config.toDatabase(): ConfigurationEntity = ConfigurationEntity(
    cnfgActiva = cnfgActiva,
    cnfgClase = cnfgClase,
    cnfgEtiq = cnfgEtiq,
    cnfgIdconfig = cnfgIdconfig,
    cnfgLentxt = cnfgLentxt,
    cnfgTipo = cnfgTipo,
    cnfgTtip = cnfgTtip,
    cnfgValfch = cnfgValfch,
    cnfgValnum = cnfgValnum,
    cnfgValsino = cnfgValsino,
    cnfgValtxt = cnfgValtxt,
    fechamodifi = fechamodifi,
    username = username,
    empresa = empresa,
)
