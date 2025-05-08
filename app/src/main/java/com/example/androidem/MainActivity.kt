package com.example.androidem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.androidem.fragments.FirstFragment
import com.example.androidem.router.AppRouter
import com.example.androidem.router.Router
import com.example.androidem.worker.ChargingWorker

class MainActivity : AppCompatActivity() {
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = AppRouter(R.id.fragment_container, this)

        if (savedInstanceState == null) {
            router.navigateTo(FirstFragment(), true, "first")
        }

        val constraints = Constraints.Builder().setRequiresCharging(true).build()

        val chargingCheckRequest =
            OneTimeWorkRequestBuilder<ChargingWorker>().setConstraints(constraints).build()

        WorkManager.getInstance(this).enqueueUniqueWork(
            "ChargingCheckWork",
            ExistingWorkPolicy.KEEP,
            chargingCheckRequest
        )
    }
}
