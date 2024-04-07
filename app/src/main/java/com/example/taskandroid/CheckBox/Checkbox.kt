package com.example.taskandroid.CheckBox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.taskandroid.R

class Checkbox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        val checkbox=findViewById<CheckBox>(R.id.checkBox)

        checkbox.setOnClickListener {
//            Toast.makeText(this,"Agree",Toast.LENGTH_SHORT).show()
                if (checkbox.isChecked){
                    Toast.makeText(this,"Agree",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this," Not Agree",Toast.LENGTH_SHORT).show()
                }
        }
    }
}