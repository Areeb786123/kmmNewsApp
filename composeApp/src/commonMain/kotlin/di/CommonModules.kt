package di

import data.repo.HomeRepo
import data.repoImp.HomeScreenRepositoryImplementation
import data.usecase.mainScreen.GetNewsUseCase
import data.usecase.mainScreen.MainScreenUseCase
import org.koin.dsl.module

val commonModules = module {
    single<HomeRepo> { HomeScreenRepositoryImplementation() }
    single { GetNewsUseCase(get()) }
    single { MainScreenUseCase(get()) }
}