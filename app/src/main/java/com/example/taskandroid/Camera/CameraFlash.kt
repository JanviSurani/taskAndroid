package com.example.taskandroid.Camera

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R

class CameraFlash : AppCompatActivity() {
    var flashLightStatus: Boolean = false
    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId: String
    private lateinit var toggleButton: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_flash)
        val isFlashAvailable = applicationContext.packageManager
            .hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)
//        if (!isFlashAvailable) {
//            showNoFlashError()
//        }
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
        toggleButton = findViewById(R.id.onOffFlashlight)
        toggleButton.setOnCheckedChangeListener { _, isChecked -> switchFlashLight(isChecked) }
//        openFlashLight()
    }

    //
//    private fun showNoFlashError() {
//        val alert = AlertDialog.Builder(this)
//            .create()
//        alert.setTitle("Oops!")
//        alert.setMessage("Flash not available in this device...")
//        alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { _, _ -> finish() }
//        alert.show()
//    }
    private fun switchFlashLight(status: Boolean) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, status)
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

//    private fun openFlashLight() {
//        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
//        val cameraId = cameraManager.cameraIdList[0]
//        if (!flashLightStatus) {
//            try {
//                cameraManager.setTorchMode(cameraId, true)
//                flashLightStatus = true
//
//            } catch (e: CameraAccessException) {
//            }
//        } else {
//            try {
//                cameraManager.setTorchMode(cameraId, false)
//                flashLightStatus = false
//            } catch (e: CameraAccessException) {
//            }
//        }
//
//    }
}