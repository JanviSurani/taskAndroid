package com.example.taskandroid.AudioPlayer.MusicPlayer


import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.taskandroid.R

class MusicPlayer : AppCompatActivity() {

    private  lateinit var cardImg:ImageView
    private  lateinit var music:MediaPlayer
    private lateinit var playBtn:ImageView
    private lateinit var pauseBtn:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)


        cardImg = findViewById(R.id.cardImg)
        playBtn = findViewById(R.id.playBtn)
        pauseBtn = findViewById(R.id.pauseBtn)

        music = MediaPlayer()
        playBtn.setOnClickListener {
            var audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

            try {

                music.setDataSource(audioUrl)
                music.prepare()
                music.start()

            } catch (e: Exception) {

                e.printStackTrace()
            }

            Toast.makeText(applicationContext, "Audio started playing..", Toast.LENGTH_SHORT).show()
        }
        pauseBtn.setOnClickListener {
            if (music.isPlaying) {
                music.stop()
                music.reset()
                music.release()
                Toast.makeText(applicationContext, "Audio has been  paused..", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(applicationContext, "Audio not played..", Toast.LENGTH_SHORT).show()
            }
        }
    }
}