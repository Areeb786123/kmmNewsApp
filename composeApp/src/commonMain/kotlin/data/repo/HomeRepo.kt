package data.repo

import data.ResponseDto.Article

interface HomeRepo {
    suspend fun getNews() : Article
}