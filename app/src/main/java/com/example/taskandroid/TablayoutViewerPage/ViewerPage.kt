package com.example.taskandroid.TablayoutViewerPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.taskandroid.R

class ViewerPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer_page)
        val viewPager2: ViewPager2 =findViewById(R.id.viewPager2)
        val images= listOf(
            R.drawable.baseline_cake_24,
            R.drawable.baseline_home_24,
            R.drawable.baseline_notifications_active_24
        )
        viewPager2.adapter= ViewPagerAdpater(images)

    }
}