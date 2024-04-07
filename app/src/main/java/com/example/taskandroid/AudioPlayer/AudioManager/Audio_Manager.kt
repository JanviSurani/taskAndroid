package com.example.taskandroid.AudioPlayer.AudioManager

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R

class Audio_Manager : AppCompatActivity() {

    lateinit var currentModeTV: TextView
    lateinit var vibrateIB: ImageButton
    lateinit var silentIB: ImageButton
    lateinit var ringerIB: ImageButton
    lateinit var audioManager: AudioManager
    var currentAudioMode = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_manager)

        vibrateIB = findViewById(R.id.idIBVibrateMode)
        silentIB = findViewById(R.id.idIBSilentMode)
        ringerIB = findViewById(R.id.idIBRingtoneMode)
        currentModeTV = findViewById(R.id.idTVCurrentMode)


        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        currentAudioMode = audioManager.ringerMode


        when (currentAudioMode) {

            AudioManager.RINGER_MODE_NORMAL -> currentModeTV.text = "Ringer Mode"
            AudioManager.RINGER_MODE_SILENT -> currentModeTV.text = "Silent Mode"
            AudioManager.RINGER_MODE_VIBRATE -> currentModeTV.text = "Vibrate Mode"

            else -> currentModeTV.text = "Fail to get mode"
        }

        vibrateIB.setOnClickListener {

            audioManager.ringerMode = AudioManager.RINGER_MODE_VIBRATE
            Toast.makeText(this@Audio_Manager, "Vibrate Mode activated..", Toast.LENGTH_SHORT).show()
            currentModeTV.text = "Vibrate Mode Activated.."
        }

        silentIB.setOnClickListener {

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val intent =
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M && !notificationManager.isNotificationPolicyAccessGranted) {
                    Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
                    startActivity(intent)
                } else {
                    Log.e("tag", "Audio Manager not accessible..")
                    audioManager.ringerMode = AudioManager.RINGER_MODE_SILENT
                    Toast.makeText(this@Audio_Manager, "Silent Mode activated..", Toast.LENGTH_SHORT)
                        .show()
                    currentModeTV.text = "Silent Mode Activated.."
                }


            ringerIB.setOnClickListener {
                audioManager.ringerMode = AudioManager.RINGER_MODE_NORMAL
                Toast.makeText(this@Audio_Manager, "Ringer Mode activated..", Toast.LENGTH_SHORT)
                    .show()
                currentModeTV.text = "Ringtone Mode Activated.."
            }
        }
    }
}