package com.example.taskandroid.Camera


import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View

import android.widget.Button

import android.widget.ImageView
import com.example.taskandroid.R


class Camera : AppCompatActivity() {

    private lateinit var clickImageId:ImageView
    private lateinit var cameraOpenId:Button
//    private lateinit var  imageurl : Uri
//    private val contact=registerForActivityResult(ActivityResultContracts.TakePicture()){
//        captureIv.setImageURI(null)
//       captureIv.setImageURI(imageurl)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)



        cameraOpenId = findViewById(R.id.captureImgBtn)
        clickImageId = findViewById(R.id.captureImageView)


        cameraOpenId.setOnClickListener(View.OnClickListener { v: View? ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(cameraIntent, 123)
        })
//        imageurl = createImageUri()
//        captureIv=findViewById(R.id.captureImageView)
//        val captureImgBtn=findViewById<Button>(R.id.captureImgBtn)
//
//        captureImgBtn.setOnClickListener{
//               contact.launch(imageurl)
//        }
//    }
//    private fun createImageUri():Uri{
//        val image= File(filesDir,"camera_photos.png")
//        return FileProvider.getUriForFile(this,
//            "androidx.core.content.FileProvider",
//            image
//            )
//    }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Match the request 'pic id with requestCode
        if (requestCode == 123) {
            // BitMap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // Set the image in imageview for display
            clickImageId.setImageBitmap(photo)
        }
    }

//    companion object {
//        // Define the pic id
//        private const val pic_id = 123
//    }
}

//    fun takePhoto(){
//        val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//       if (intent.resolveActivity(packageManager)!=null){
//
//           startActivityForResult(intent,cameraRequest)
//       }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode==cameraRequest&& resultCode== RESULT_OK){
//            val imageView:ImageView=findViewById(R.id.image)
//            val bitmap=data?.extras?.get("data")as Bitmap
//            imageView.setImageBitmap(bitmap)
//        }
//    }
//
//
//
//    }


//        title = "KotlinApp"
//        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA)
//            == PackageManager.PERMISSION_DENIED) {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), cameraRequest)
//            }
//        imageView = findViewById(R.id.image)
//        val photoButton: Button = findViewById(R.id.button)
//        photoButton.setOnClickListener {
//            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(cameraIntent, cameraRequest)
//        }
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == cameraRequest) {
//            val photo: Bitmap = data?.extras?.get("data") as Bitmap
//            imageView.setImageBitmap(photo)
//        }
//    }

//        cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//        preview = Preview.Builder().build()
//
//        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
//        cameraProviderFuture.addListener({
//            cameraProvider = cameraProviderFuture.get()
//
//            bindPreview()
//        }, ContextCompat.getMainExecutor(this))
//    }
//
//    private fun bindPreview() {
//
////        preview.setSurfaceProvider(preview.createSurfaceProvider())
//
//        val camera = cameraProvider.bindToLifecycle(
//            this, cameraSelector, preview
//        )
//    }


//