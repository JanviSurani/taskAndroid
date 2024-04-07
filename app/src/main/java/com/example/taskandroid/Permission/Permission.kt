package com.example.taskandroid.Permission

import android.content.DialogInterface
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.taskandroid.R

class Permission : AppCompatActivity() {
    private val multiplePermissionId = 14
    private val multiplePermissionNameList = arrayListOf(

        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.CAMERA,

        )
    //val FINE_LOCATION_RQ=101
//    private lateinit var permissionLauncher: ActivityResultLauncher<String>
//    private var isReadPermissionGranted=false
//    private  var isLocationPermissionGranted=false
//    private  var isRecordPermissionGranted=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        val multiplePermissionBtn = findViewById<Button>(R.id.multiplePermissionBtn)
        multiplePermissionBtn.setOnClickListener {
            if (checkMultiplePermission()) {
                doOperation()
            }
        }
    }

    private fun doOperation() {
        Toast.makeText(
            this,"All Permission G ranted Sucessfully!",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun checkMultiplePermission(): Boolean {
        val listPermissionNeeded = arrayListOf<String>()

        for (permission in multiplePermissionNameList) {
        if (ContextCompat.checkSelfPermission(
            this,permission)!=PackageManager.PERMISSION_GRANTED){
            listPermissionNeeded.add(permission)
        }
        }
        if (listPermissionNeeded.isNotEmpty()){
            ActivityCompat.requestPermissions(
                this,listPermissionNeeded.toTypedArray(),
                multiplePermissionId
            )
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==multiplePermissionId){
            if (grantResults.isNotEmpty()){
                var isGrant=true
                for(element in grantResults){
                    if (element==PackageManager.PERMISSION_DENIED){
                        isGrant=false
                    }
                }
                if(isGrant){
                    doOperation()
                }else{
                    var someDenied=false
                    for (permission in permissions){
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            this,permission
                        )){
                            if (ActivityCompat.checkSelfPermission(
                                this,permission
                            )==PackageManager.PERMISSION_DENIED){
                                someDenied=true
                            }
                        }
                    }
                    if (someDenied){
                            appSettingOpen(this)
                    }else{
                            warningPermissionDialog(this){_:DialogInterface,which:Int->
                                when(which){
                                    DialogInterface.BUTTON_POSITIVE->
                                        checkMultiplePermission()
                                }
                            }
                    }
                }
            }
        }
    }
}
//    private fun onClick() {
//        checkForPermission(android.Manifest.permission.ACCESS_FINE_LOCATION,"location",FINE_LOCATION_RQ)
//    }

//
//    private  fun checkForPermission(permission: String,name:String,requestCode:Int){
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
//            when{
//                ContextCompat.checkSelfPermission(applicationContext,permission)==PackageManager.PERMISSION_GRANTED
//                ->{
//                    Toast.makeText(applicationContext,"$name permission granted",Toast.LENGTH_LONG).show()
//
//                }
//                shouldShowRequestPermissionRationale(permission)->showDialog(permission,name,requestCode)
//
//                else->ActivityCompat.requestPermissions(this, arrayOf(permission),requestCode)
//            }
//
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        fun innerCheck(name: String) {
//            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//
//            Toast.makeText(applicationContext,"$name permission refued",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(applicationContext,"$name permission Granted",Toast.LENGTH_LONG).show()
//            }
//        }
//        when(requestCode){
//            FINE_LOCATION_RQ->innerCheck(name = "location")
//        }
//    }
//
//    private fun showDialog(permission: String, name: String, requestCode: Int) {
//         val builder=AlertDialog.Builder(this)
//        builder.apply {
//            setMessage("Permission to acess your $name is required to use this app")
//            setTitle("Permission required")
//            setPositiveButton("ok"){dialog,which->
//                ActivityCompat.requestPermissions(this@Permission, arrayOf(permission),requestCode)
//            }
//        }
//        val dialog:AlertDialog=builder.create()
//        dialog.show()
//
//    }




