package com.example.taskandroid.Animation

import android.os.Bundle

import android.view.animation.AnimationUtils

import android.widget.ImageView
//import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R


class Animation : AppCompatActivity(){


//    lateinit var btn1: Button
//    lateinit var btn2: Button
//    lateinit var image: ImageView

//   lateinit var  fadeOut:Button
//  private lateinit var  textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
//        fade_in.setOnClickListener {
//            textView.visibility = View.VISIBLE
//            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
//            textView.startAnimation(animationFadeIn)
//        }
//        fade_out.setOnClickListener {
//            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
//            textView.startAnimation(animationFadeOut)
//            Handler().postDelayed({
//                textView.visibility = View.GONE
//            }, 1000)
//        }
        val imageView = findViewById<ImageView>(R.id.image)
        imageView.animation = AnimationUtils.loadAnimation(this, R.anim.shake_animation)

//       val fade_in=findViewById<Button>(R.id.fade_in)
//        fade_in.animation=AnimationUtils.loadAnimation(this,R.anim.fade_in)
//      val  fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)



//   btn_fadein.setOnClickListener(this)
//    }
//
//    override fun onClick(p0: View?) {
//        var id = null
//        when(p0?:id){
//            R.id.btn_fadein->textview.start
//        }
    }

//    override fun onClick(p0: View?) {
//
//    }


//        btn1 = findViewById(R.id.btnOne)
//        btn2 = findViewById(R.id.btnTwo)
//        image = findViewById(R.id.image)
//
//        animateImage()
//        animateImage1()
//    }

//
//    private fun animateImage() {
//
//        btn1.setOnClickListener {
//            image.animate().apply {
//                duration = 1000
//                alpha(.5f)
//                scaleXBy(.5f)
//                scaleYBy(.5f)
//                rotationYBy(360f)
//                translationYBy(200f)
//            }.withEndAction {
//                image.animate().apply {
//                    duration = 1000
//                    alpha(1f)
//                    scaleXBy(-.5f)
//                    scaleYBy(-.5f)
//                    rotationYBy(360f)
//                    translationYBy(-200f)
//
//                }
//            }.start()
//        }
//    }
//
//    private fun animateImage1() {
//
//        btn2.setOnClickListener {
//            image.animate().apply {
//                duration = 1000
//                alpha(.5f)
//                scaleXBy(.5f)
//                scaleYBy(.5f)
//                rotationYBy(0f)
//                translationYBy(200f)
//            }.withEndAction {
//                image.animate().apply {
//                    duration = 1000
//                    alpha(1f)
//                    scaleXBy(-.5f)
//                    scaleYBy(-.5f)
//                    rotationYBy(0f)
//                    translationYBy(-200f)
//
//                }
//            }.start()
//        }
//    }


}