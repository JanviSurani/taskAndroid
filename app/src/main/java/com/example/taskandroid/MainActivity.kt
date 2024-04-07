package com.example.taskandroid

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.BroadCastReciver.AirplaneModeChangeReceiver

//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import android.content.pm.PackageManager
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.result.ActivityResultLauncher
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.appcompat.app.AlertDialog
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
//    val id:Int = 10
//    val language:String = "kotlin"

    lateinit var receiver: AirplaneModeChangeReceiver


    //    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
//    private var isReadPermissionGranted=false
//    private var isLocationPermissionGranted=false
//    private var isRecordPermissionGranted=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val crashButton = Button(this)
//        crashButton.text = "Test Crash"
//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//
//        addContentView(crashButton, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT))
    }
}
//        receiver = AirplaneModeChangeReceiver()
//        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
//
//           registerReceiver(receiver, it)
////        }
////   }
//    }
//
////    fun exit(view: View) {}
//}

//override fun onStop() {
//       super.onStop()
//       unregisterReceiver(receiver)
//    }
//}
//



//        val button = findViewById<Button>(R.id.button)
//
//        button.setOnClickListener {
//            val builder = AlertDialog.Builder(this)
//            //set title for alert dialog
//            builder.setTitle(R.string.dialogTitle)
//            //set message for alert dialog
//            builder.setMessage(R.string.dialogMessage)
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
//
//            //performing positive action
//            builder.setPositiveButton("Yes") { dialogInterface, which ->
//                Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
//            }
//            //performing cancel action
//            builder.setNeutralButton("Cancel") { dialogInterface, which ->
//                Toast.makeText(
//                    applicationContext,
//                    "clicked cancel\n operation cancel",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//            //performing negative action
//            builder.setNegativeButton("No") { dialogInterface, which ->
//                Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
//            }
//            // Create the AlertDialog
//            val alertDialog: AlertDialog = builder.create()
//            // Set other dialog properties
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//        }
//    }
//}

//        btnCamera = findViewById(R.id.btnCamera)
//        btnLocation = findViewById(R.id.btnLocation)
//
//        btnCamera.setOnClickListener {
//
//            if (checkPermission(Manifest.permission.CAMERA)) {
//                //openCamera()
//            } else {
//                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//                    AlertDialog.Builder(this)
//                        .setMessage("Need camera permission to capture image. Please provide permission to access your camera.")
//                        .setPositiveButton("OK") { dialogInterface, i ->
//                            dialogInterface.dismiss()
//                            ActivityCompat.requestPermissions(
//                                this,
//                                arrayOf(Manifest.permission.CAMERA),
//                                201
//                            )
//                        }
//                        .setNegativeButton("Cancel") { dialogInterface, i ->
//                            dialogInterface.dismiss()
//                        }
//                        .create()
//                        .show();
//                } else {
//                    ActivityCompat.requestPermissions(
//                        this,
//                        arrayOf(Manifest.permission.CAMERA,Manifest.permission.READ_MEDIA_IMAGES),
//                        201
//                    )
//                }
//            }


            /**/
//
//        }
//
//    }
//
//    private fun checkPermission(permission: String): Boolean {
//        return ContextCompat.checkSelfPermission(
//            this,
//            permission
//        ) == PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 201) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
//                //openCamera()
//            } else {
//                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

//    permissionLauncher=registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
//        permissions->
//        isReadPermissionGranted=permissions[Manifest.permission.READ_EXTERNAL_STORAGE]?: isReadPermissionGranted
//        isLocationPermissionGranted=permissions[Manifest.permission.ACCESS_FINE_LOCATION]?: isLocationPermissionGranted
//        isRecordPermissionGranted=permissions[Manifest.permission.RECORD_AUDIO]?: isRecordPermissionGranted
//    }
//
//      requestPermission()
//
//
//
//    private  fun requestPermission(){
//        isReadPermissionGranted= ContextCompat.checkSelfPermission(
//            this, Manifest.permission.READ_EXTERNAL_STORAGE
//        )==PackageManager.PERMISSION_GRANTED
//
//        isLocationPermissionGranted= ContextCompat.checkSelfPermission(
//            this, Manifest.permission.ACCESS_FINE_LOCATION
//        )==PackageManager.PERMISSION_GRANTED
//
//        isRecordPermissionGranted= ContextCompat.checkSelfPermission(
//            this, Manifest.permission.RECORD_AUDIO
//        )==PackageManager.PERMISSION_GRANTED
//
//        var permissionRequest:MutableList<String>=ArrayList()
//
//        if(!isReadPermissionGranted){
//            permissionRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
//        }
//        if(!isLocationPermissionGranted){
//            permissionRequest.add(Manifest.permission.ACCESS_FINE_LOCATION)
//        }
//        if(!isRecordPermissionGranted){
//            permissionRequest.add(Manifest.permission.RECORD_AUDIO)
//        }
//        if(permissionRequest.isNotEmpty()){
//            permissionLauncher:lauch(permissionRequest.toTypeArray())
//        }
//
//    }



//
//       val secondActbutton=findViewById<Button>(R.id.sec_act_btn)
//        secondActbutton.setOnClickListener{
//            val std=Intent(this,ActivitySecond::class.java).apply {
//                putExtra("id_value", id)
//              putExtra("language_value", language)
//            }
//
//
//            startActivity(std)
//        }
//}

