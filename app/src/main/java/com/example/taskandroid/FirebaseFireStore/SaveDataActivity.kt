package com.example.taskandroid.FirebaseFireStore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskandroid.databinding.ActivitySaveDataBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class SaveDataActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySaveDataBinding
    private  var db=Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySaveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val sName=binding.nameEt.text.toString().trim()
            val sAddress=binding.addressEt.text.toString().trim()
            val sEmail=binding.emailEt.text.toString().trim()
            val sPassword=binding.passET.text.toString().trim()

            val userMap= hashMapOf(
                "name" to sName,
                "email" to sEmail,
                "address" to sAddress,
                "password" to sPassword
            )

            val userId=FirebaseAuth.getInstance()
            db.collection("user").document().set(userMap)
                .addOnSuccessListener {
                    Toast.makeText(this,"Sucessfully Added!!",Toast.LENGTH_SHORT).show()
                    binding.nameEt.text?.clear()
                    binding.addressEt.text?.clear()
                    binding.emailEt.text?.clear()
                    binding.passET.text?.clear()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failure!!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}