package com.example.androidem.app

import android.app.Application
import com.example.featurehome.di.DaggerHomeComponent
import com.example.featurehome.di.HomeComponent
import com.example.featurehome.presentation.HomeViewModel

class App : Application() {
    private lateinit var homeComponent: HomeComponent
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate() {
        super.onCreate()

        homeComponent = DaggerHomeComponent.factory()
            .create(this)

        homeViewModel = homeComponent.getHomeViewModel()
        homeViewModel.getData()
    }
}