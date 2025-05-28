package com.example.featurehome.di

import androidx.lifecycle.ViewModel
import com.example.featurehome.presentation.HomeViewModel
import dagger.Binds
import dagger.Module

@Module
interface HomeViewModelModule {
    @Binds
    fun bindHomeViewModel(impl: HomeViewModel): ViewModel
}