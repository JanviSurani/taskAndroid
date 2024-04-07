package com.example.taskandroid.Intent.Implicit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityImplicitIntentBinding

class ImplicitIntent : AppCompatActivity() {

    private lateinit var binding:ActivityImplicitIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityImplicitIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.button.setOnClickListener(){
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://developer.android.com/develop/"))
            startActivity(intent)
            /*  intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/"))
            startActivity(intent)*/
        }

    }
}