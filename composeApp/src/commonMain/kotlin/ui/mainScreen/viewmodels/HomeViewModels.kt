package ui.mainScreen.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repo.HomeRepo
import kotlinx.coroutines.launch


class HomeViewModels(private val repo :HomeRepo) : ViewModel() {
    fun callApi(){
        viewModelScope.launch {
            println("testingTheDataXXX   ${repo.getNews().title}")
            repo.getNews().title
        }

    }
}