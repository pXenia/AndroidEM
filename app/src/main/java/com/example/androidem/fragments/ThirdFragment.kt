package com.example.androidem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.androidem.R

class ThirdFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prevButton = view.findViewById<Button>(R.id.back_button)
        val nextButton = view.findViewById<Button>(R.id.next_button)
        view.findViewById<TextView>(R.id.tv).text = "Третий фрагмент"
        setupNavigation(prevButton, nextButton)
    }

    override fun nextButtonClickListener() {
        router.backTo("first")
    }
}