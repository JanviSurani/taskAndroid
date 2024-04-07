package com.example.taskandroid.FirebaseAuthentication.GoogleAuthentication

import android.bluetooth.BluetoothDevice.EXTRA_NAME
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivitySignInGoogleBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignInGoogleActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInGoogleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.logout.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(applicationContext, NextActivity::class.java)
            startActivity(intent)
        }
    }
}