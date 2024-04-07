package com.example.taskandroid.AudioPlayer.VideoPlayer

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R


class VideoView : AppCompatActivity() {

    var videoView:VideoView?=null
    var mediaController:MediaController?=null
    var videoUrl =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        videoView=findViewById<View>(R.id.videoView)as VideoView?

        if (mediaController==null){
            mediaController=MediaController(this)
            mediaController!!.setAnchorView(this.videoView)
        }
     videoView!!.setMediaController(mediaController)

        val uri: Uri = Uri.parse(videoUrl)


        videoView!!.setVideoURI(uri)
//        val uri = Uri.parse("" +
//                "/demos/sample-videos/small.mp4")
//       videoView!!.setVideoURI(uri)
         videoView!!.requestFocus()
        videoView!!.start()
        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext,"Video End",Toast.LENGTH_LONG).show()
        }
        videoView!!.setOnErrorListener{mediaPlayer,i,i2->

            Toast.makeText(applicationContext,"Failure Occured",Toast.LENGTH_LONG).show()
            false
        }
    }
}