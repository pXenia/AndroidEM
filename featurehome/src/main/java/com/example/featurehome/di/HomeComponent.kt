package com.example.featurehome.di

import android.content.Context
import com.example.featurehome.presentation.HomeViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    HomeModule::class,
    HomeViewModelModule::class,
    DataProviderModule::class
])
interface HomeComponent {
    fun getHomeViewModel(): HomeViewModel

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): HomeComponent
    }
}
