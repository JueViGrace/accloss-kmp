package org.clo.database.company

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import org.clo.database.core.DbHelper
import org.clo.database.Empresa as CompanyEntity

class DefaultCompanyLocalSource(
    override val scope: CoroutineScope,
    private val dbHelper: DbHelper
) : CompanyLocalSource {
    override suspend fun getCompanies(): Flow<List<CompanyEntity>> {
        return scope.async {
            dbHelper.withDatabase { db ->
                db.empresaQueries
                    .getEmpresas()
                    .asFlow()
                    .mapToList(scope.coroutineContext)
            }
        }.await()
    }

    override suspend fun getCompany(code: String): Flow<CompanyEntity?> {
        return scope.async {
            dbHelper.withDatabase { db ->
                db.empresaQueries
                    .getEmpresa(codigoEmpresa = code)
                    .asFlow()
                    .mapToOne(scope.coroutineContext)
            }
        }.await()
    }

    override suspend fun addCompany(company: CompanyEntity) {
        scope.async {
            dbHelper.withDatabase { db ->
                db.transaction {
                    db.empresaQueries.addEmpresa(company)
                }
            }
        }.await()
    }

    override suspend fun deleteCompany(company: String) {
        scope.async {
            dbHelper.withDatabase { db ->
                db.transaction {
                    db.empresaQueries.deleteEmpresa(codigoEmpresa = company)
                }
            }
        }.await()
    }
}
