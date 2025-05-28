package com.example.core.di

import com.example.core.data.ArticleApi
import com.example.core.data.UserApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginModule::class, ArticlesModule::class])
interface CoreComponent {
    fun userApi(): UserApi
    fun articleApi(): ArticleApi
}
