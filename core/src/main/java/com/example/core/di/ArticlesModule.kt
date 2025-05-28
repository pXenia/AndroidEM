package com.example.core.di

import com.example.core.data.ArticleApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ArticlesModule {
    @Provides
    @Singleton
    @Named("article")
    fun provideArticleRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://article-example.com/")
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleApi(): ArticleApi {
        return ArticleApi.createFake()
    }
}