package com.mohaberabi.androidbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class TimerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (it.action == Intent.ACTION_TIME_TICK) {
                Toast.makeText(context, "Time Changed", Toast.LENGTH_LONG).show()
            }
        }

    }
}