package com.example.taskandroid.TablayoutViewerPage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Fr_1()
            }
            1 -> {
                return Fr_2()
            }
            2 -> {
                return Fr_3()
            }
            else -> {
                return Fr_1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "fragment 1"
            }
            1 -> {
                return "Fragment 2"
            }
            2 -> {
                return "Fragment 3"
            }
        }
        return super.getPageTitle(position)
    }

}