package data.repoImp

import client
import data.ResponseDto.Article
import data.ResponseDto.NewsResponse
import data.contants.HttpRoutes.TOP_HEADLINES
import data.repo.HomeRepo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.request
import io.ktor.http.encodedPath

class HomeScreenRepositoryImplementation() : HomeRepo {
    override suspend fun getNews(): List<Article>? {

        val response: NewsResponse = client.get {
            url {
                encodedPath = "top-headlines"
             parameters.append("country", "in")
            }
        }.body()

        return response.articles

    }

}