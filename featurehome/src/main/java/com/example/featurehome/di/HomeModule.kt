package com.example.featurehome.di

import com.example.featurehome.data.HomeRepositoryImpl
import com.example.featurehome.domain.HomeRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface HomeModule {
    @Binds
    @Singleton
    fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}

