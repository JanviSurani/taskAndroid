package com.example.taskandroid.Intent.Explicite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityExpliciteIntentBinding

class ExpliciteIntent : AppCompatActivity() {


    private lateinit var binding:ActivityExpliciteIntentBinding
    val id:Int = 10
    val language:String = "kotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExpliciteIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("id_value", id)
            intent.putExtra("language_value", language)
            startActivity(intent)
        }
    }
}