package com.example.core.di

import com.example.core.data.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class LoginModule {
    @Provides
    @Singleton
    @Named("user")
    fun provideUserRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://user-examle.com/")
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return UserApi.createFake()
    }
}
