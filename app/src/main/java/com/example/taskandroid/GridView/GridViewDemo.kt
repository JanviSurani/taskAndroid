package com.example.taskandroid.GridView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class GridViewDemo : AppCompatActivity() {
    var imageList= listOf(
        DataModel(
            image_id = R.drawable.second,
            text = "World"
        ), DataModel(
            image_id = R.drawable.four,
            text = "HillStation"
        ),DataModel(
            image_id = R.drawable.fifth,
            text = "Sukoon"
        ),DataModel(
            image_id = R.drawable.third,
            text = "Peace"
        ),DataModel(
            image_id = R.drawable.second,
            text = "World"
        ),DataModel(
            image_id = R.drawable.fifth,
            text = "HillStation"
        ),DataModel(
            image_id = R.drawable.four,
            text = "Sukoon"
        ),DataModel(
            image_id = R.drawable.third,
            text = "Peace"
        ),


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_demo)

        val recyclerview=findViewById<RecyclerView>(R.id.recyclerView)
        var manager=GridLayoutManager(this,2)
        recyclerview.layoutManager=manager
        recyclerview.adapter=Adpater(imageList)
    }


}