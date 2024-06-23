package ui.mainScreen.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.ResponseDto.Article
import data.repo.HomeRepo
import data.usecase.mainScreen.MainScreenUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeViewModels(private val useCase: MainScreenUseCase) : ViewModel() {
    private val _trendingNews = MutableStateFlow<List<Article>>(emptyList())
    val trendingNews: StateFlow<List<Article>> get() = _trendingNews
    fun callApi() {
        viewModelScope.launch {
            useCase.getNewsUseCase.invoke().collectLatest {
                println("testingTheDataXXX   ${it}")
                if (it != null) {
                    _trendingNews.value = it
                }
            }
        }
    }
}