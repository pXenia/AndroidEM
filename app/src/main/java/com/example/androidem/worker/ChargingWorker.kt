package com.example.androidem.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ChargingWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        NotificationHelper.showNotification(
            context = applicationContext,
            id = NOTIFICATION_ID,
            title = "Устройство на зарядке"
        )
        return Result.success()
    }

    companion object {
        const val NOTIFICATION_ID = 111
    }
}
