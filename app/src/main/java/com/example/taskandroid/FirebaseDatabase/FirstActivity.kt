package com.example.taskandroid.FirebaseDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.taskandroid.R

class FirstActivity : AppCompatActivity() {
    private lateinit var btnInsertData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

     btnInsertData = findViewById(R.id.btnInsertData)

        btnInsertData.setOnClickListener {
            val intent = Intent(this, InsertionActivity::class.java)
            startActivity(intent)
        }

//        btnFetchData.setOnClickListener {
//            val intent = Intent(this, FetchingActivity::class.java)
//            startActivity(intent)
//        }


    }
}