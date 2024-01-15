package com.hideonshroud.fitapp

import NotificationWorker
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import java.util.Calendar

class TimeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_TIME_TICK) {
            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val desiredHours = setOf(9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)

            if (currentHour in desiredHours && currentMinute == 0) {
                Log.d("HourlyBroadcastReceiver", "Logging at $currentHour:$currentMinute")

                scheduleNotificationWorker(context)
            }

        }
    }
    private fun scheduleNotificationWorker(context: Context?) {
        val notificationWork = OneTimeWorkRequest.Builder(NotificationWorker::class.java)
            .build()

        WorkManager.getInstance(context!!)
            .enqueue(notificationWork)
    }
}