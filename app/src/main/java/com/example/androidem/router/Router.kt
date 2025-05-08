package com.example.androidem.router

import androidx.fragment.app.Fragment

interface Router {
    fun navigateTo(
        fragment: Fragment,
        addToBackStack: Boolean = true,
        tag: String? = null
    )

    fun goBack()
    fun backTo(backStackName: String)
    fun clearBackStack()
}