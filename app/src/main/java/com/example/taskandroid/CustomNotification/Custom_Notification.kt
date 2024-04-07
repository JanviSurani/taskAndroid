package com.example.taskandroid.CustomNotification


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.taskandroid.NavigationDrawer.ActivitySecond
import com.example.taskandroid.R


class Custom_Notification : AppCompatActivity() {


    private val KEY_REPLY="key_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_notification)
        val showNotificationButton=findViewById<Button>(R.id.showNotificationButton)
        showNotificationButton.setOnClickListener{
            showNotification()
        }
    }

    private fun showNotification() {

        val tapResultIntent=Intent(this, ActivitySecond::class.java)
        val NOTIFICATION_REQUEST_CODE=78

//        val updatedPendingIntent = PendingIntent.getActivity(
//            applicationContext,
//            NOTIFICATION_REQUEST_CODE,
//            updatedIntent,
//            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT // setting the mutability flag
//        )
        val pendingIntent:PendingIntent=PendingIntent.getActivity(
            this,0,tapResultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val channelID="10000"
       val notificationManager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager



        var remoteInput:androidx.core.app.RemoteInput=androidx.core.app.RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Insert you name here")

        }.build()
        val replyAction:NotificationCompat.Action=NotificationCompat.Action.Builder(
            0,
            "Reply",
           pendingIntent
        ).addRemoteInput(remoteInput).build()


        val builder=NotificationCompat.Builder(applicationContext,channelID)
            .setSmallIcon(R.drawable.baseline_message_24)
            .setContentTitle("Android Notification")
            .setContentText("Android work with java and kotlin")
            .setContentIntent(pendingIntent)
            .addAction(replyAction)


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel= NotificationChannel(channelID,"Custom Notification",NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableVibration(true)
            notificationManager.createNotificationChannel(channel)
            builder.setChannelId(channelID)
        }
        val notification=builder.build()
        notificationManager.notify(1000,notification)

    }
}

