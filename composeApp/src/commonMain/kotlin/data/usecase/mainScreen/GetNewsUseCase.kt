package data.usecase.mainScreen

import data.ResponseDto.Article
import data.repo.HomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetNewsUseCase(private val homeRepo: HomeRepo) {
    operator fun invoke(): Flow<List<Article>?> {
        return flow {
            val response = homeRepo.getNews()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}