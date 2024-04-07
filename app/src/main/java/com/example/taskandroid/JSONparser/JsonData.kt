package com.example.taskandroid.JSONparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.taskandroid.R
import org.json.JSONArray
import org.json.JSONObject

class JsonData : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_data)

        textView=findViewById(R.id.textView)

        val jsonData=applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
              "example",
                "raw",
                applicationContext.packageName
            )

        ).bufferedReader().use { it.readText() }


        val outputJsonString=JSONObject(jsonData)
        val users=outputJsonString.getJSONArray("users")as JSONArray
        for (i in 0 until users.length()){
            val userId=users.getJSONObject(i).getString("userId")
            val firstName=users.getJSONObject(i).getString("firstName")
            val lastName=users.getJSONObject(i).getString("lastName")
            val phoneNumber=users.getJSONObject(i).getString("phoneNumber")
            val emailAddress=users.getJSONObject(i).getString("emailAddress")

            val previousData=textView.text
            val data:String="$userId\n$firstName\n$lastName\n$phoneNumber\n$emailAddress"
            textView.text=previousData.toString()+data
        }

    }
}