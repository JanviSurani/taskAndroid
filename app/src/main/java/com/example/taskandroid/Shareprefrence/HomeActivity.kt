package com.example.taskandroid.Shareprefrence

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.taskandroid.MainActivity
import com.example.taskandroid.R

class HomeActivity : AppCompatActivity() {


    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val USERNAME_KEY = "username_key"
        const val PASSWORD_KEY = "password_key"
    }

    private lateinit var sharedpreferences:SharedPreferences
    private var username: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        username = sharedpreferences.getString(USERNAME_KEY, null)

        val welcomeTV = findViewById<TextView>(R.id.idTVWelcome)
        welcomeTV.text = "Welcome $username"
        val logoutBtn = findViewById<Button>(R.id.idBtnLogout)
        logoutBtn.setOnClickListener {

            val editor = sharedpreferences.edit()
            editor.clear()
            editor.apply()

            val i = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

}
