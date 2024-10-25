package org.clo.accloss.core.data.network

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.invalid_response_body_try_again_later
import ac_closs.composeapp.generated.resources.server_took_too_long_to_answer
import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.engine.cio.CIO
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.clo.accloss.core.common.Constants.BASE_URL
import org.clo.accloss.core.common.Constants.SERVER_ERROR

object KtorClient {
    fun client(baseUrl: String? = null): HttpClient {
        return HttpClient(CIO) {
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
    }

    internal inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> {
        return try {
            ApiOperation.Success(data = apiCall())
        } catch (e: Exception) {
            ApiOperation.Failure(
                error = when (e) {
                    is NoTransformationFoundException -> {
                        Res.string.invalid_response_body_try_again_later
                    }
                    is SocketTimeoutException -> {
                        Res.string.server_took_too_long_to_answer
                    }
                    else -> {
                        SERVER_ERROR
                    }
                }
            )
        }
    }
}
