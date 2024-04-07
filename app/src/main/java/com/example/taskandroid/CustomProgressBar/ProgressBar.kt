package com.example.taskandroid.CustomProgressBar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import com.example.taskandroid.R

class ProgressBar : AppCompatActivity() {

    internal var status = 0
    private val handler = Handler()
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        title = "KotlinApp"
        val resources = resources
        val drawable = resources.getDrawable(R.drawable.circularprogressbar)
        val progressBar: ProgressBar = findViewById(R.id.idcircularProgressbar)
        progressBar.progress = 0
        progressBar.secondaryProgress = 100
        progressBar.max = 100
        progressBar.progressDrawable = drawable
        textView = findViewById(R.id.textView)
        Thread {
            while (status < 100) {
                status += 1
                handler.post {
                    progressBar.progress = status
                    textView.text = String.format("%d%%", status)
                }
                try {
                    Thread.sleep(16)
                }
                catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }
}