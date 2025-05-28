package com.example.featurehome.data

import com.example.core.data.ArticleApi
import com.example.core.data.UserApi
import com.example.core.domain.ArticleResponse
import com.example.core.domain.UserResponse
import com.example.featurehome.domain.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val articleApi: ArticleApi
) : HomeRepository {
    override suspend fun getUser(): UserResponse {
        return userApi.getUser()
    }

    override suspend fun getArticles(): List<ArticleResponse> {
        return articleApi.getArticles()
    }
}