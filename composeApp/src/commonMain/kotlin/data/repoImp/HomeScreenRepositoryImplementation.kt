package data.repoImp

import data.ResponseDto.Article
import data.contants.HttpRoutes.TOP_HEADLINES
import data.repo.HomeRepo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.request

class HomeScreenRepositoryImplementation(private val client : HttpClient) : HomeRepo {
    override suspend fun getNews(): Article {
       return  client.get(TOP_HEADLINES).body()
    }
}