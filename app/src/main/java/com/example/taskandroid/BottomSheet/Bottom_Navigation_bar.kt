package com.example.taskandroid.BottomSheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityBottomNavigationBarBinding

class Bottom_Navigation_bar : AppCompatActivity() {

    private  lateinit var binding: ActivityBottomNavigationBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBottomNavigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Bottom_Home())


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->replaceFragment(Bottom_Home())
                R.id.account ->replaceFragment(Bottom_Account())
                R.id.settings ->replaceFragment(Bottom_Settings())

                else->{

                }

            }


            true
        }
    }


    private  fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}