package com.example.taskandroid.Serialization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.taskandroid.Model.Person
import com.example.taskandroid.R
import com.google.gson.Gson


class SerializationDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serialization_demo)

        //  TOJSON
        var gson = Gson()
        var jsonString = gson.toJson(Person("Testing", "test", 35, 5.7F, 80))
        Log.d("ToJsonData", "$jsonString")

       // FROMJSON
        var person2=Gson().fromJson(jsonString,Person::class.java)
        Log.d("FromJsonData","${person2.fname},,${person2.lname}${person2.age},${person2.height},${person2.weight}")
    }
}

