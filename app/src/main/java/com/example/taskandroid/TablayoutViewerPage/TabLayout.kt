package com.example.taskandroid.TablayoutViewerPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.taskandroid.R
import com.google.android.material.tabs.TabLayout

class TabLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PageAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

    }
}