package com.example.core.data

import com.example.core.domain.UserResponse
import retrofit2.http.GET

interface UserApi {
    @GET("user/profile")
    fun getUser(): UserResponse

    companion object {
        fun createFake(): UserApi = object : UserApi {
            override fun getUser(): UserResponse {
                return UserResponse(name = "User", email = "user@example.com")
            }
        }
    }
}