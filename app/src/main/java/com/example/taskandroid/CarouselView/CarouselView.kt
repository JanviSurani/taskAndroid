package com.example.taskandroid.CarouselView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.Model.ImageItem
import com.example.taskandroid.Adpater.ImageAdpater
import com.example.taskandroid.R
import java.util.UUID

class CarouselView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel_view)

        val imageRV=findViewById<RecyclerView>(R.id.imageRV)


        val imageList= arrayListOf(
            ImageItem(
                UUID.randomUUID().toString() ,
                "drawable/first.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString() ,
               "https://www.freepik.com/free-ai-image/3d-rendering-forest-tiger-with-woman_96363981.htm#fromView=subhome&regularType=ai&position=1"),
            ImageItem(
              UUID.randomUUID().toString() ,
                "https://www.freepik.com/free-ai-image/abstract-colorful-cube-shape-sculpture_94961146.htm#fromView=subhome&regularType=ai&position=39"),
            ImageItem(
              UUID.randomUUID().toString() ,
               "https://www.freepik.com/free-ai-image/ai-generated-boat-picture_94962936.htm#fromView=subhome&regularType=ai&position=13"),
            ImageItem(
               UUID.randomUUID().toString() ,
                 "https://www.freepik.com/free-vector/hand-drawn-media-naranja-illustration_37115440.htm"),
            ImageItem(
            UUID.randomUUID().toString() ,
              "https://www.freepik.com/free-vector/hand-drawn-media-naranja-illustration_37115440.htm")


        )
        val imageAdpater=ImageAdpater()
        imageRV.adapter=imageAdpater
        imageAdpater.submitList(imageList)
    }
}

