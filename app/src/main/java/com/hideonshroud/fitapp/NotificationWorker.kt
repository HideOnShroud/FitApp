package com.hideonshroud.fitapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        // Define the notification
        val notification = NotificationCompat.Builder(applicationContext, "channel_id")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Drink Some Water")
            .setContentText("Please be sure to drink some water!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // Display the notification
        val notificationManager = NotificationManagerCompat.from(applicationContext)
        notificationManager.notify(1, notification)

        // Indicate whether the work finished successfully
        return Result.success()
    }
}