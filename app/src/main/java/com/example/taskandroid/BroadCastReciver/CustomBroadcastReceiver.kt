package com.example.taskandroid.BroadCastReciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CustomBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.action?.let {
            Log.d("???", "action $it ")
        }

        Log.d("???", "onReceive: ")
    }
}