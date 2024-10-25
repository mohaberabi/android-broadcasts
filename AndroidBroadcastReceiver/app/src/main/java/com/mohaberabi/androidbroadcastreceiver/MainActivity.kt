package com.mohaberabi.androidbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mohaberabi.androidbroadcastreceiver.ui.theme.AndroidBroadcastReceiverTheme

class MainActivity : ComponentActivity() {
    private val timerReceiver by lazy {
        TimerReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBroadcastReceiverTheme {
           
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(Intent.ACTION_TIME_TICK)
        registerReceiver(timerReceiver, intentFilter)
        val intent = Intent(this, TimerReceiver::class.java)
        sendBroadcast(intent)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(timerReceiver)
    }
}

