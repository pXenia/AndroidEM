package com.example.featurehome.di

import com.example.core.data.ArticleApi
import com.example.core.data.UserApi
import com.example.core.di.CoreComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataProviderModule {

    @Provides
    @Singleton
    fun provideCoreComponent(): CoreComponent {
        return DaggerCoreComponent.builder().build()
    }

    @Provides
    fun provideUserApi(coreComponent: CoreComponent): UserApi {
        return coreComponent.userApi()
    }

    @Provides
    fun provideArticlesApi(coreComponent: CoreComponent): ArticleApi {
        return coreComponent.articleApi()
    }
}