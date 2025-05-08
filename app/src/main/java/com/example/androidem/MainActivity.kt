package com.example.androidem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidem.fragments.FirstFragment
import com.example.androidem.router.Router
import com.example.androidem.router.AppRouter

class MainActivity : AppCompatActivity() {
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = AppRouter(R.id.fragment_container, this)

        if (savedInstanceState == null) {
            router.navigateTo(FirstFragment(), true, "first")
        }
    }
}