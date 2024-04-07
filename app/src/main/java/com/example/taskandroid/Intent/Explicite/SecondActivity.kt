package com.example.taskandroid.Intent.Explicite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskandroid.databinding.ActivitySecond2Binding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecond2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val id = bundle?.get("id_value")
        val language = bundle?.get("language_value")
        Toast.makeText(applicationContext, id.toString() + " " + language, Toast.LENGTH_LONG).show()
        binding.button2.setOnClickListener() {
            intent = Intent(this, ExpliciteIntent::class.java)
            startActivity(intent)
        }
    }
}