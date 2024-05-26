package di

import androidx.lifecycle.viewmodel.compose.viewModel
import data.repo.HomeRepo
import data.repoImp.HomeScreenRepositoryImplementation
import data.repoImp.Test
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpCallValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import ui.mainScreen.viewmodels.HomeViewModels

val  commonModules = module {
single<HomeRepo>{HomeScreenRepositoryImplementation(get ())}
    single {
        HttpClient {
            install(Logging) {
                logger = io.ktor.client.plugins.logging.Logger.DEFAULT
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    isLenient = false
                    explicitNulls = true
                })
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 10000L
                requestTimeoutMillis = 10000L
                socketTimeoutMillis = 10000L
            }

            install(HttpCallValidator) {
                handleResponseExceptionWithRequest { cause, _ -> println("exception $cause") }
            }

        }
    }
}