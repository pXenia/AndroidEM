package com.example.featurehome.domain

import com.example.core.domain.ArticleResponse
import com.example.core.domain.UserResponse

interface HomeRepository {
    suspend fun getUser(): UserResponse
    suspend fun getArticles(): List<ArticleResponse>
}