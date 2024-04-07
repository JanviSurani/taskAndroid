package com.example.taskandroid.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.taskandroid.MainActivity
import com.example.taskandroid.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

    val iv_note=findViewById<ImageView>(R.id.iv_note)
    iv_note.alpha=0f
       iv_note.animate().setDuration(1500).alpha(1f).withEndAction {
            val i=Intent(this, MainActivity::class.java)
            startActivity(i)
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            finish()
        }



    }
}

