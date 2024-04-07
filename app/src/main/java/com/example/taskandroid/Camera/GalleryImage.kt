package com.example.taskandroid.Camera

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatImageView
import com.example.taskandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GalleryImage : AppCompatActivity() {

    private lateinit var pickImage: FloatingActionButton
    private lateinit var selectedImage: AppCompatImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_image)


        pickImage = findViewById(R.id.pick_image)
        selectedImage = findViewById(R.id.selected_image)

        pickImage.setOnClickListener {
            val pickImg = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            changeImage.launch(pickImg)
        }


    }
    private val changeImage =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data = it.data
                val imgUri = data?.data
                selectedImage.setImageURI(imgUri)
            }
        }
}