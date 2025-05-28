package com.example.core.data

import com.example.core.domain.ArticleResponse
import retrofit2.http.GET

interface ArticleApi {
    @GET("articles")
    fun getArticles(): List<ArticleResponse>

    companion object {
        fun createFake(): ArticleApi = object : ArticleApi {
            override fun getArticles(): List<ArticleResponse> {
                return listOf(
                    ArticleResponse(title = "Статья 1", content = "Текст статьи 1"),
                    ArticleResponse(title = "Статья 2", content = "Текст статьи 2")
                )
            }
        }
    }
}
