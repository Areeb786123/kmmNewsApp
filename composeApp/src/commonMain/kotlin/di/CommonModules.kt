package di

import data.repo.Test
import org.koin.dsl.module

fun commonModules() = module {
    single<Test> {
        Test()
    }
}