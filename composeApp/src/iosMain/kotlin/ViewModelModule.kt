import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.mainScreen.viewmodels.HomeViewModels

actual  val viewModelModule = module {
    singleOf(::HomeViewModels)
}