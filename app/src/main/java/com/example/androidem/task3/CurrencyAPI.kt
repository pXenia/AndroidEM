package com.example.androidem.task3

import retrofit2.http.GET

interface CurrencyAPI {
    @GET("daily_json.js")
    suspend fun getCurrency(): CurrencyResponse
}