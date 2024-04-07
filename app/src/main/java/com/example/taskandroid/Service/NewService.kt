package com.example.taskandroid.Service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.support.v4.media.session.MediaSessionCompat
import com.example.taskandroid.R
import com.example.taskandroid.Service.NewService.Constants.CHANNEL_ID
import com.example.taskandroid.Service.NewService.Constants.MUSIC_NOTIFICATION_ID


class NewService : Service() {

    object Constants {
        const val CHANNEL_ID = "your_id"
        const val MUSIC_NOTIFICATION_ID = 123
    }

    private val PAUSE = "pause"
    private val PLAY = "play"
    private lateinit var musicPlayer: MediaPlayer
//    private val mediaSession = MediaSessionCompat(context, "VideoPlayback")
//
//    init {
//        mediaSession.setCallback(SimpleMediaSessionCallback())
//    }



    override fun onCreate() {
        super.onCreate()
        initMusic()
        createNotificationChannel()


    }

    private fun showNotification() {
        val notificationIntent = Intent(this, ForegroundService::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

//        val pPPendingIntent = PendingIntent.getBroadcast(
//            this,
//            0,
//            Intent("PlayPause"),
//            PendingIntent.FLAG_UPDATE_CURRENT
//        )
        val mediaSession = MediaSessionCompat(this, "PlayerService")

//       val mediaStyle = Notification.MediaStyle().setMediaSession(mediaSession.sessionToken)

//        var remoteInput:androidx.core.app.RemoteInput=androidx.core.app.RemoteInput.Builder(PAUSE).run {
//
//        }.build()
//        val previousAction: Notification.Action.Builder = Notification.Action.Builder(
//            R.drawable.baseline_pause_24,
//            "Pause",
//            pendingIntent
//
//        )


        val notification = Notification
            .Builder(this, CHANNEL_ID)
            .setContentText("Music Player")
            .setSmallIcon(R.drawable.baseline_music_note_24)
//          .addAction(previousAction)
            .addAction(R.drawable.baseline_skip_previous_24, "Previous", pendingIntent) // #0
            .addAction(R.drawable.baseline_pause_24, "Pause", pendingIntent) // #1
            .addAction(R.drawable.baseline_play_arrow_24, "Play", pendingIntent) // #1
            .addAction(R.drawable.baseline_skip_next_24, "Next", pendingIntent) // #
            .setContentIntent(pendingIntent)
//          .setContentIntent(pPPendingIntent)
            .build()


        startForeground(MUSIC_NOTIFICATION_ID, notification)

    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        if (musicPlayer.isPlaying) {

            musicPlayer.stop()
        } else {
            musicPlayer.start()

        }

        return START_STICKY
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID, "New Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }


    }

    private fun initMusic() {
        musicPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        musicPlayer.isLooping = true
        musicPlayer.setVolume(100F, 100F)

    }

    override fun onDestroy() {
        super.onDestroy()
        if (musicPlayer.isPlaying) musicPlayer.stop()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}

