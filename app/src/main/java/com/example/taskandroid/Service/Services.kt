package com.example.taskandroid.Service

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R

class Services : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnStop:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        var intent=Intent(this, MyService::class.java)
        startService(intent)

        btnStart=findViewById(R.id.btnStart)
        btnStop=findViewById(R.id.btnStop)

        btnStart.setOnClickListener {
            startService((Intent(this,MyService::class.java)))
        }

        btnStop.setOnClickListener {
            stopService(Intent(this,MyService::class.java))
        }
    }
}