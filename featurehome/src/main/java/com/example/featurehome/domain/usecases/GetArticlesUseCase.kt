package com.example.featurehome.domain.usecases

import com.example.core.domain.ArticleResponse
import com.example.featurehome.domain.HomeRepository
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): List<ArticleResponse> {
        return repository.getArticles()
    }
}