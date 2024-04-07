package com.example.taskandroid.DataBase.SqlStorage

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.taskandroid.DataBase.SqlDatabase.DbHelper
import com.example.taskandroid.R


class SqlStorage : AppCompatActivity() {
    private lateinit var Title: EditText
    private lateinit var imageBtn: Button
    var CameraRequestCode: Int = 200
    var GalleryRequestCode: Int = 100
    private lateinit var _addBtn: Button
    private lateinit var _Image:ImageView
    var db = DbHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_storage)
        Title = findViewById<EditText>(R.id.text)
//        _Image = findViewById<ImageView>(R.id.GotImage)
        imageBtn = findViewById<Button>(R.id.ImageBtn)
        _addBtn = findViewById<Button>(R.id.Add)
        _addBtn.setOnClickListener {
            var _title = Title.text.trim().toString()
        }

        imageBtn.setOnClickListener {
            var dialogueBox = AlertDialog.Builder(this)
            var dialogueOptions = arrayOf("Camera", "Gallery")
            dialogueBox.setTitle("Make Choice")
            dialogueBox.setItems(dialogueOptions, object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    if (dialogueOptions[p1].equals("Camera")) {
                        OpenCamera()
                    }
                    if (dialogueOptions[p1].equals("Gallery")) {
                        OpenGallery()
                    }
                }
            })
            dialogueBox.show()
        }
    }

    private fun OpenGallery() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            var GalleryIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(GalleryIntent, GalleryRequestCode)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                GalleryRequestCode
            )
        }
    }

    private fun OpenCamera() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val CameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(CameraIntent, CameraRequestCode)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                CameraRequestCode
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CameraRequestCode -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    OpenCamera()
                } else {
                    Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                }
            }

            GalleryRequestCode -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    OpenGallery()
                } else {
                    Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CameraRequestCode -> {
                if (resultCode == Activity.RESULT_OK) {
                    val img = data?.extras?.get("data")
//                    GotImage.setImageBitmap(img as Bitmap)
                }
            }

            GalleryRequestCode -> {
                if (resultCode == RESULT_OK) {
                    var URI = data!!.data
                    var Image = MediaStore.Images.Media.getBitmap(this.contentResolver, URI)
//                    GotImage.setImageBitmap(Image)
                }
            }
        }
    }



}