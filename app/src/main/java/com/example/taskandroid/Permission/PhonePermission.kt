package com.example.taskandroid.Permission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityPhonePermissionBinding

class PhonePermission : AppCompatActivity() {


    var REQUEST_PHONE_CALL= 1

    private lateinit var binding:ActivityPhonePermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPhonePermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.makeCallButton.setOnClickListener {
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(
                this,arrayOf(Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)
            else{
                makeCall()
            }
        }

    }

    private fun makeCall(){
        val numberText ="8678667787"
        val intent= Intent(Intent.ACTION_CALL)
        intent.setData(Uri.parse("tel:$numberText"))
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this,"Permission denied", Toast.LENGTH_LONG).show()
            return
        }
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_CALL){
            makeCall()
        }
    }

}


