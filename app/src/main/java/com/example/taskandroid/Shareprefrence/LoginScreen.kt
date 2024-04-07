package com.example.taskandroid.Shareprefrence

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R


class LoginScreen : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val USERNAME_KEY = "username_key"
        const val PASSWORD_KEY = "password_key"
    }

    private lateinit var sharedpreferences: SharedPreferences
    private var username: String? = null
    private var password: String? = null

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)


        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)


        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        username = sharedpreferences.getString("USERNAME_KEY", null)
        password = sharedpreferences.getString("PASSWORD_KEY", null)


        loginBtn.setOnClickListener {

            if (TextUtils.isEmpty(usernameInput.text.toString()) && TextUtils.isEmpty(passwordInput.text.toString())) {

                Toast.makeText(
                    this@LoginScreen,
                    "Please Enter Email and Password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val editor = sharedpreferences.edit()

                editor.putString(USERNAME_KEY, usernameInput.text.toString())
                editor.putString(PASSWORD_KEY, passwordInput.text.toString())

                editor.apply()

                val i = Intent(this@LoginScreen, HomeActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (username!= null && password != null) {
            val intent = Intent(this@LoginScreen, HomeActivity::class.java)
            startActivity(intent);

        }
    }


}

//        loginBtn.setOnClickListener {
//            val username=usernameInput.text.toString()
//            val pasword=passwordInput.text.toString()
//            Log.i(TAG, "Username:$username and Password:$pasword ")




//            val shared = getSharedPreferences(mypreference, MODE_PRIVATE)
//            val editor = shared.edit()
//            editor.putString("mn", editText.getText().toString())
//            editor.commit()
//
//            val prefs = getSharedPreferences(mypreference, MODE_PRIVATE)
//            val ap = prefs.getString("mn", "")
//            text.setText(ap)



