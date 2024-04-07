package com.example.taskandroid.LoginApiCalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.taskandroid.Model.Data
import com.example.taskandroid.Model.Responcelogin
import com.example.taskandroid.R
import com.example.taskandroid.Viewmodel.LoginApiCallingViewModel

class LoginApiCalling : AppCompatActivity() {

    lateinit var viewModel: LoginApiCallingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_api_calling)
        val login_btn = findViewById<Button>(R.id.login_btn)
        initViewModel()
        login_btn.setOnClickListener {
            createUser()
        }

    }

    private fun createUser() {
        val username_input = findViewById<EditText>(R.id.username_input)
        val password_input = findViewById<EditText>(R.id.password_input)


        val data = Data(username_input.text.toString(), password_input.text.toString())
        viewModel.createNewUser(data)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(LoginApiCallingViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer<Responcelogin?> {
            if (it == null) {
                Toast.makeText(this@LoginApiCalling,"failed to create user",Toast.LENGTH_LONG).show()
            } else {


                Toast.makeText(this@LoginApiCalling,"Successfully create user",Toast.LENGTH_LONG).show()
            }
        })

    }
}