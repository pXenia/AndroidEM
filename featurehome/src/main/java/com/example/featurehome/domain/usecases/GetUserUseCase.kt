package com.example.featurehome.domain.usecases

import com.example.core.domain.UserResponse
import com.example.featurehome.domain.HomeRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): UserResponse {
        return repository.getUser()
    }
}