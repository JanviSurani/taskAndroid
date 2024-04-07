package com.example.taskandroid.Camera.RecordingVideo


import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import com.example.taskandroid.databinding.ActivityVideoBinding


class Video : AppCompatActivity() {
    private lateinit var binding:ActivityVideoBinding
    var flashLightStatus: Boolean = false
    private lateinit var cameraManager: CameraManager
//    private lateinit var cameraId: String
    private  val REQUEST_RECORD_AUDIO_PERMISSION = 200
    private var permissionToRecordAccepted = false
    private val CAMERA_REQUEST = 3000
    val CAMERA_FRONT = "1"
    val CAMERA_BACK = "0"

    private var cameraId = CAMERA_BACK


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isFlashAvailable = applicationContext.packageManager
            .hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        binding.capture.setOnLongClickListener{

            false
        }
        binding.toggleFlash.setOnClickListener {
            openFlashLight()
        }
        binding.flipCamera.setOnClickListener {
//
//            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(cameraIntent, CAMERA_REQUEST)


//            val cameraIds: Array<String> = cameraManager.cameraIdList
//            var cameraId: String = ""
//            for (id in cameraIds) {
//                val cameraCharacteristics = cameraManager.getCameraCharacteristics(id)
//                //If we want to choose the rear facing camera instead of the front facing one
//                if (cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_FRONT)
//                    continue
//            }
//
//            val previewSize = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)!!.getOutputSizes(ImageFormat.JPEG).maxByOrNull { it.height * it.width }!!
//            val imageReader = ImageReader.newInstance(previewSize.width, previewSize.height, ImageFormat.JPEG, 1)
//            imageReader.setOnImageAvailableListener(onImageAvailableListener, backgroundHandler)
//            cameraId = id
//        }
//
//        }
    }
//        private fun startCamera() {
//            bindCameraUseCases()
//
//            // Listener for button used to switch cameras
//            switchButton = view.findViewById(R.id.switch_button)
//            switchButton.setOnClickListener {
//                lensFacing = if (CameraX.LensFacing.FRONT == lensFacing) {
//                    CameraX.LensFacing.BACK
//                } else {
//                    CameraX.LensFacing.FRONT
//                }
//                try {
//                    // Only bind use cases if we can query a camera with this orientation
//                    CameraX.getCameraWithLensFacing(lensFacing)
//                    bindCameraUseCases()
//                } catch (exc: Exception) {
//                    // Do nothing
//                }
//            }
//        }
//
//        private fun bindCameraUseCases() {
//            // Make sure that there are no other use cases bound to CameraX
//            CameraX.unbindAll()
//
//            val previewConfig = PreviewConfig.Builder().apply {
//                setLensFacing(lensFacing)
//            }.build()
//            val preview = Preview(previewConfig)
//
//            val imageCaptureConfig = ImageCaptureConfig.Builder().apply {
//                setLensFacing(lensFacing)
//            }.build()
//            imageCapture = ImageCapture(imageCaptureConfig)
//
//            // Apply declared configs to CameraX using the same lifecycle owner
//            CameraX.bindToLifecycle(this, preview, imageCapture)
//        }
//
////   override fun onOpened(camera: CameraDevice) {
////       cameraManager.openCamera(cameraId, cameraStateCallback,backgroundHandler)
////    }
////
////    override fun onDisconnected(cameraDevice: CameraDevice) {
////
////    }
////
////    override fun onError(cameraDevice: CameraDevice, error: Int) {
////        val errorMsg = when(error) {
////            ERROR_CAMERA_DEVICE -> "Fatal (device)"
////            ERROR_CAMERA_DISABLED -> "Device policy"
////            ERROR_CAMERA_IN_USE -> "Camera in use"
////            ERROR_CAMERA_SERVICE -> "Fatal (service)"
////            ERROR_MAX_CAMERAS_IN_USE -> "Maximum cameras in use"
////            else -> "Unknown"
////        }
////        Log.e("TAG", "Failure when trying to connect camera $errorMsg")
////    }
}
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == CAMERA_REQUEST) {
//            val photo = data!!.extras!!["data"] as Bitmap?
//          val  imageView = findViewById<View>(R.id.imageView) as ImageView
//            imageView!!.setImageBitmap(photo)
//        }
//    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted) finish()
    }


    private fun openFlashLight() {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        if (!flashLightStatus) {
            try {
                cameraManager.setTorchMode(cameraId, true)
                flashLightStatus = true

            } catch (e: CameraAccessException) {
            }
        } else {
            try {
                cameraManager.setTorchMode(cameraId, false)
                flashLightStatus = false
            } catch (e: CameraAccessException) {
            }
        }

    }
//    private val surfaceTextureListener = object : TextureView.SurfaceTextureListener {
//        override fun onSurfaceTextureAvailable(texture: SurfaceTexture, width: Int, height: Int) {
//
//        }
//        override fun onSurfaceTextureSizeChanged(texture: SurfaceTexture, width: Int, height: Int) {
//
//        }
//
//        override fun onSurfaceTextureDestroyed(texture: SurfaceTexture): Boolean {
//
//        }
//        override fun onSurfaceTextureUpdated(texture: SurfaceTexture) {
//
//        }
//    }
//
//
//
//    private fun switchCameras() {
//        mCameraOpenCloseLock.release()
//
//        mCameraDevice.close()
//        val mCameraManager = getActivity().getSystemService(CAMERA_SERVICE) as CameraManager
//        try {
//            var mCameraId = mCameraManager.cameraIdList[0]
//            if (mCameraId == "0") {   // If currently on FRONT camera (0 = CameraCharacteristics.LENS_FACING_FRONT)
//                mCameraId =
//                    "1" // switch to BACK camera (1 = CameraCharacteristics.LENS_FACING_BACK)
//                binding.flipCamera.setImageResource(R.drawable.ic_camera_front)
//            } else {  // If currently on BACK camera
//                mCameraId = "0" // switch to front camera
//               binding.flipCamera.setImageResource(com.example.taskandroid.R.drawable.ic_camera_back)
//            }
//            try {
//                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
//                    == PackageManager.PERMISSION_GRANTED
//                ) {
//                    mCameraManager.openCamera(mCameraId, mStateCallback, null)
//                } else {
//                    requestVideoPermissions()
//                }
//            } catch (e: CameraAccessException) {
//                e.printStackTrace()
//            }
//        } catch (e: CameraAccessException) {
//            Toast.makeText(getActivity(), "Cannot access the camera.", Toast.LENGTH_SHORT).show()
//            getActivity().finish()
//        }
//    }
//
//    private fun getActivity(): Context? {
//        TODO("Not yet implemented")
//    }
//
//    private fun requestVideoPermissions() {
//
//    }
//    fun switchCamera() {
//        if (cameraId == CAMERA_FRONT) {
//            cameraId = CAMERA_BACK
////            closeCamera()
////            reopenCamera()
////            switchCameraButton.setImageResource(R.drawable.ic_camera_front)
//        } else if (cameraId == CAMERA_BACK) {
//            cameraId = CAMERA_FRONT
////            closeCamera()
////            reopenCamera()
////            switchCameraButton.setImageResource(R.drawable.ic_camera_back)
//        }
//    }
//
////    fun reopenCamera() {
////        if (mTextureView.isAvailable()) {
////            openCamera(mTextureView.getWidth(), mTextureView.getHeight())
////        } else {
////            mTextureView.setSurfaceTextureListener(mSurfaceTextureListener)
////        }
////    }



}