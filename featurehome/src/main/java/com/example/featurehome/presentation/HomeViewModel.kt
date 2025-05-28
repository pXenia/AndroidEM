package com.example.featurehome.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featurehome.domain.usecases.GetArticlesUseCase
import com.example.featurehome.domain.usecases.GetUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

val TAG = "HomeData"

class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase, private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    fun getData() {
        viewModelScope.launch {
            val user = getUserUseCase()
            val articles = getArticlesUseCase()
            Log.d(TAG, ("User: $user, Articles: $articles"))
        }
    }
}