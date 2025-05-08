package com.example.androidem.fragments

import android.content.Context
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.androidem.MainActivity
import com.example.androidem.router.Router

abstract class BaseFragment : Fragment() {
    protected lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        router = (requireActivity() as MainActivity).router
    }

    protected fun setupNavigation(prevButton: Button, nextButton: Button) {
        prevButton.setOnClickListener {
            router.goBack()
        }

        nextButton.setOnClickListener {
            nextButtonClickListener()
        }
    }

    abstract fun nextButtonClickListener()
}