package com.example.taskandroid.GestureTouch

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R

class Gestures_Touch : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestures_touch)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("DEBUG_TAG", "Action was DOWN")
                true
            }
            MotionEvent.ACTION_MOVE -> {

                Log.d("DEBUG_TAG", "Action was MOVE")
                true
            }
            MotionEvent.ACTION_UP -> {
                Log.d("DEBUG_TAG", "Action was UP")
                true
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.d("DEBUG_TAG", "Action was CANCEL")
                true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                Log.d("DEBUG_TAG", "Movement occurred outside bounds of current screen element")
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
}