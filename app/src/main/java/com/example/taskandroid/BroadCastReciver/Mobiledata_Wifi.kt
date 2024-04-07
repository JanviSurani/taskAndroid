package com.example.taskandroid.BroadCastReciver


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.taskandroid.R


class Mobiledata_Wifi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobiledata_wifi)

        val inflateLayout=findViewById<View>(R.id.networkError)
        val  networkConnection= Network_Con(applicationContext)
        networkConnection.observe(this){
         if (it){
           Toast.makeText(this,"Connected", Toast.LENGTH_SHORT).show()
             inflateLayout.visibility=View.GONE
         }else{
             inflateLayout.visibility=View.VISIBLE
             Toast.makeText(this," Not Connected", Toast.LENGTH_SHORT).show()
         }
        }
    }
}