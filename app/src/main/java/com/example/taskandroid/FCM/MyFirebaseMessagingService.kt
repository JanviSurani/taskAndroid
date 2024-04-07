package com.example.taskandroid.FCM

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.taskandroid.MainActivity
import com.example.taskandroid.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


const val channelId="notification_channel"
const val channelName="com.example.taskandroid"



class MyFirebaseMessagingService :FirebaseMessagingService(){
    val TAG=".MainActivity"

    override fun onNewToken(token: String) {
    Log.d(TAG, "Refreshed token: $token")
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
       if (remoteMessage.getNotification()!= null){
           generateNotification(remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!)

       }
    }

        fun generateNotification(title:String,message:String){
            val intent=Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)

            var builder:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.baseline_message_24)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)



            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager

            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                val notificationChannel=NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_DEFAULT)
                notificationManager.createNotificationChannel(notificationChannel)
            }
                notificationManager.notify(0,builder.build())

        }
}