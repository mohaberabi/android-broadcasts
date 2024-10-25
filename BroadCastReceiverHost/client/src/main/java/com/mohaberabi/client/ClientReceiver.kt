package com.mohaberabi.client

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ClientReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let { int ->
            if (int.action == "com.mohaberabi.broadcastreceiverhost.ACTION_SEND") {
                Log.d("reco", "RECEIEVED")
                val message = int.getStringExtra("greetingKey") ?: "unknown"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}