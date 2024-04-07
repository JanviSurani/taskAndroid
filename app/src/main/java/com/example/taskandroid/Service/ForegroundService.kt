package com.example.taskandroid.Service

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.databinding.ActivityForegroundServiceBinding

class ForegroundService : AppCompatActivity() {

    private lateinit var binding: ActivityForegroundServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForegroundServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startStopService()
        }
    }


    private fun startStopService() {
        if (isMyServiceRunning(NewService::class.java)) {

            Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show()
            stopService(Intent(this, NewService::class.java))

        } else {
            Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show()
            startService(Intent(this, NewService::class.java))


        }

    }

    private fun isMyServiceRunning(mClass: Class<NewService>): Boolean {
        val manager: ActivityManager = getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager

        for (service: ActivityManager.RunningServiceInfo in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (mClass.name.equals(service.service.className)) {
                return true
            }
        }
        return false
    }
}