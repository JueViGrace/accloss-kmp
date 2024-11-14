package com.closs.auth.data.repository

import com.closs.auth.data.mappers.toDatabase
import com.closs.auth.data.mappers.toDomain
import com.closs.auth.domain.repository.AuthRepository
import com.closs.core.api.KtorClient
import com.closs.core.database.helper.DbHelper
import com.closs.core.types.data.ApiOperation
import com.closs.core.types.data.DataError
import com.closs.core.types.data.RequestState
import com.closs.core.types.data.auth.Session
import com.closs.core.types.data.company.Company
import com.closs.core.types.data.company.CompanyResponse
import com.closs.core.types.data.user.User
import com.closs.core.types.data.user.UserResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class AuthRepositoryImpl(
    private val ktorClient: KtorClient = KtorClient,
    private val dbHelper: DbHelper,
    private val scope: CoroutineScope,
    private val coroutineContext: CoroutineContext
) : AuthRepository {
    override suspend fun fetchCompany(code: String): RequestState<Company> {
        return withContext(coroutineContext) {
            when (
                val response = ktorClient.call<CompanyResponse>(
                    url = "/webservice/c_validar_empresa.php?codigo=$code"
                )
            ) {
                is ApiOperation.Failure -> {
                    RequestState.Error(response.error)
                }
                is ApiOperation.Success -> {
                    val data = response.data.toDomain()

                    if (data.codigoEmpresa.isEmpty()) {
                        return@withContext RequestState.Error(error = DataError.NotFound())
                    }

                    RequestState.Success(data = data)
                }
            }
        }
    }

    override suspend fun login(baseUrl: String, username: String, password: String): RequestState<User> {
        return withContext(coroutineContext) {
            when (
                val response = ktorClient.call<UserResponse>(
                    baseUrl = baseUrl,
                    url = "/webservice/c_validar_usuario.php?username=$username&password=$password"
                )
            ) {
                is ApiOperation.Failure -> {
                    RequestState.Error(error = response.error)
                }
                is ApiOperation.Success -> {
                    val data = response.data.toDomain()

                    if (data.username.isEmpty()) {
                        return@withContext RequestState.Error(error = DataError.NotFound())
                    }

                    RequestState.Success(data = data)
                }
            }
        }
    }

    override fun getCurrentUser(): Flow<RequestState<Session>> = flow {
        emit(RequestState.Loading)
        val data = dbHelper.withDatabase { db ->
            dbHelper.executeOne(
                query = db.sessionQueries.getCurrentUser()
            )
        }

        if (data == null) {
            return@flow emit(RequestState.Error(error = DataError.NullDataError()))
        }

        emit(RequestState.Success(data = data.toDomain()))
    }.flowOn(coroutineContext)

    override fun getSession(): Flow<RequestState<Session>> = flow {
        emit(RequestState.Loading)
        val data =
            dbHelper.withDatabase { db ->
                dbHelper.executeOneAsFlow(
                    query = db.sessionQueries.getCurrentUser()
                )
            }

        data.collect { value ->
            if (value == null) {
                return@collect emit(RequestState.Error(error = DataError.NullDataError()))
            }

            emit(RequestState.Success(data = value.toDomain()))
        }
    }.flowOn(coroutineContext)

    override fun getSessions(): Flow<RequestState<List<Session>>> = flow {
        emit(RequestState.Loading)
        val data = dbHelper.withDatabase { db ->
            dbHelper.excecuteListAsFlow(
                query = db.sessionQueries.getSessions()
            )
        }

        data.collect { value ->
            emit(RequestState.Success(data = value.map { it.toDomain() }))
        }
    }.flowOn(coroutineContext)

    override suspend fun addSession(session: Session) {
        scope.async {
            dbHelper.withDatabase { db ->
                db.transaction {
                    db.sessionQueries.addSession(session = session.toDatabase())
                }
            }
        }.await()
    }

    override suspend fun updateSession(id: String) {
        scope.async {
            dbHelper.withDatabase { db ->
                db.transaction {
                    db.sessionQueries.inactiveSessions(
                        id = id
                    )
                    db.sessionQueries.startSession(
                        id = id,
                    )
                }
            }
        }.await()
    }

    override suspend fun deleteSession(session: Session) {
        scope.async {
            dbHelper.withDatabase { db ->
                db.transaction {
                    db.tasasQueries.deleteTasas(session.id)
                    db.productQueries.deleteProducts(session.id)
                    db.lineasFacturaQueries.deleteLineasFactura(session.id)
                    db.lineasPedidoQueries.deleteLineasPedido(session.id)
                    db.facturaQueries.deleteFacturas(session.id)
                    db.pedidoQueries.deletePedidos(session.id)
                    db.clienteQueries.deleteClientes(session.id)
                    db.estadisticaQueries.deleteEstadisticas(session.id)
                    db.vendedorQueries.deleteVendedor(session.id)
                    db.gerenciaQueries.deleteGerencias(session.id)
                    db.userQueries.deleteUser(session.user, session.id)
                    db.empresaQueries.deleteEmpresa(session.id)
                    db.configurationQueries.deleteConfig(session.id)
                    db.sessionQueries.deleteSession(
                        id = session.id
                    )
                }
            }
        }.await()
    }

    override suspend fun endSession() {
        scope.async {
            dbHelper.withDatabase { db ->
                db.transaction {
                    db.sessionQueries.endSession()
                }
            }
        }.await()
    }
}
