package com.mohaberabi.broadcastreceiverhost

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohaberabi.broadcastreceiverhost.ui.theme.BroadCastReceiverHostTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val AUTHORITY = "com.mohaberabi.broadcastreceiverhost.ACTION_SEND"
        private const val GREETING_KEY = "greetingKey"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BroadCastReceiverHostTheme {

                Scaffold { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(20.dp)
                    ) {

                        Text(
                            text = "Broadcast receiver host app",
                        )
                        Button(
                            onClick = {
                                sendBroadCastToClient()
                            },
                        ) {
                            Text(text = "Send the broadcast you wish for ")
                        }

                    }
                }
            }
        }
    }

    private fun sendBroadCastToClient() {

        val intent = Intent(AUTHORITY).apply {
            putExtra(
                GREETING_KEY,
                "Hey iam the host iam telling you to do something important"
            )
        }
        sendBroadcast(intent)
    }
}

