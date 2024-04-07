package com.example.taskandroid.AlertDialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.taskandroid.R

class Custom_Alert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogOut: Button = findViewById(R.id.btnLogOut)
        btnLogOut.setOnClickListener{
            val message: String? = "Are You Sure You Want to Log Out"
            showCustomDialogBox(message)
        }
    }
    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)

        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_custom_alert)

//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage: TextView = dialog.findViewById(R.id.tvMessage)
        val btnYes: Button = dialog.findViewById(R.id.btnYes)
        val btnNo: Button = dialog.findViewById(R.id.btnNo)

        tvMessage.text = message
        btnYes.setOnClickListener {
            Toast.makeText(this, "click on yes", Toast.LENGTH_LONG).show()
        }
        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}






