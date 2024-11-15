package com.closs.core.api

import com.closs.core.types.common.Constants.BASE_URL
import com.closs.core.types.data.ApiOperation
import com.closs.core.types.data.DataError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.json.Json
import kotlin.coroutines.coroutineContext

class KtorClient {
    fun client(baseUrl: String? = null): HttpClient = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.BODY

            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                    explicitNulls = true
                }
            )
        }

        install(DefaultRequest) {
            url(baseUrl ?: BASE_URL)
        }
    }

    suspend inline fun<reified T> call(baseUrl: String? = null, url: String): ApiOperation<T> {
        return try {
            val data = client(baseUrl).get(url)

            when (data.status.value) {
                HttpStatusCode.OK.value -> {
                    ApiOperation.Success(data = data.body())
                }
                HttpStatusCode.BadRequest.value -> {
                    ApiOperation.Failure(error = DataError.BadRequest())
                }
                HttpStatusCode.NotFound.value -> {
                    ApiOperation.Failure(error = DataError.NotFound())
                }
                HttpStatusCode.InternalServerError.value -> {
                    ApiOperation.Failure(error = DataError.ServerDataError())
                }
                else -> {
                    ApiOperation.Failure(error = DataError.UnknownDataError())
                }
            }
        } catch (e: Exception) {
            coroutineContext.ensureActive()
            ApiOperation.Failure(error = DataError.UnexpectedDataError(e.message))
        }
    }
}
