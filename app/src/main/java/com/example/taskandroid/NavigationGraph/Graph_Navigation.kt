package com.example.taskandroid.NavigationGraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.taskandroid.R

class Graph_Navigation : AppCompatActivity() {

    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_navigation)

        val navHostController=supportFragmentManager
            .findFragmentById(R.id.fragment)as NavHostFragment
        navController=navHostController.navController

//
//        val bundle = bundleOf("mobile" to binding.etMobileNo.text.toString().trim())
//        Navigation.findNavController(binding.root).navigate(R.id.action_nav_register_to_nav_verify_otp, bundle)

    }
}