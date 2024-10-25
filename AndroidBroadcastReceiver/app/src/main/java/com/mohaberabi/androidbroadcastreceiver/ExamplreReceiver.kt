package com.mohaberabi.androidbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            when (it.action) {
                Intent.ACTION_BOOT_COMPLETED -> {
                    Toast.makeText(context, "Mobile Was Started", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}