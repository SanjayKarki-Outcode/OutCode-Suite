package com.outcodesoftware.outcodesuite.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient by lazy {
    HttpClient {
        install(HttpTimeout) {
            socketTimeoutMillis = 30000
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 30000
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
//                    AppLogger.log("http client: $message")
                }
            }
            level = LogLevel.BODY

        }

        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)

        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
                useAlternativeNames = true
            })

        }







    }


}