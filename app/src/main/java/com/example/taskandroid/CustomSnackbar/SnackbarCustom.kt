package com.example.taskandroid.CustomSnackbar

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import com.google.android.material.snackbar.Snackbar


class SnackbarCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_custom)

        var llmain:LinearLayout=findViewById(R.id.main)
        var btn1:Button=findViewById(R.id.btn1)
        var btn2:Button=findViewById(R.id.btn2)
        var btn4:Button=findViewById(R.id.btn4)
        var btn3:Button=findViewById(R.id.btn3)


        btn1.setOnClickListener {
            val defaultSnackbar=Snackbar.make(llmain,"Hii Dream Developer",Snackbar.LENGTH_LONG)
            defaultSnackbar.show()
        }

        btn2.setOnClickListener {
            val customSnackbar=Snackbar.make(llmain,"try again!!",Snackbar.LENGTH_LONG).setAction("RETRY"){}
            customSnackbar.setActionTextColor(Color.RED)
            customSnackbar.show()

        }

        btn3.setOnClickListener {
            val actionSnackbar=Snackbar.make(llmain,"Message is Deleted",Snackbar.LENGTH_LONG).setAction("UNDO",object :View.OnClickListener{
                override fun onClick(p0: View?) {
                    val snackbar=Snackbar.make(llmain,"Message is restored!!",Snackbar.LENGTH_LONG)
                    snackbar.show()
                }

            })
            actionSnackbar.show()
        }

        btn4.setOnClickListener {
            val snack = Snackbar.make(
                findViewById(android.R.id.content),
                "Had a snack at Snackbar",
                Snackbar.LENGTH_LONG
            )
            val view = snack.view
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params
            snack.show()
        }
    }
}