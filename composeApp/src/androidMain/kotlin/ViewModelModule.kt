import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ui.mainScreen.viewmodels.HomeViewModels


actual val viewModelModule = module {
    viewModel{(HomeViewModels(get()))}

}