package com.example.androidem.task3

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://www.cbr-xml-daily.ru/"

    private val responseCodeInterceptor = Interceptor {
        val request = it.request()
        val response = it.proceed(request)

        Log.d("CODE_RESPONSE", "Code: ${response.code}")
        response
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(responseCodeInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val currencyApi: CurrencyAPI by lazy {
        retrofit.create(CurrencyAPI::class.java)
    }
}