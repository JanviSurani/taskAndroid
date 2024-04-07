package com.example.taskandroid.ImageUploadApi

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityImageApiBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream


class ImageApi : AppCompatActivity() {

    private lateinit var binding: ActivityImageApiBinding
    private lateinit var imageUri: Uri

    private  val contract=registerForActivityResult(ActivityResultContracts.GetContent()){
        imageUri=it!!
        binding.imageView.setImageURI(it)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_image_api)
        setup()
    }


    private fun setup() {
       binding.btnChange.setOnClickListener { contract.launch("image/*") }
        binding.btnUpload.setOnClickListener { upload() }
    }

    private fun upload() {

        val fileDir = applicationContext.filesDir
        val file = File(fileDir, "image.jpeg")

        val inputStream = contentResolver.openInputStream(imageUri)
        val outputStream = FileOutputStream(file)
        inputStream!!.copyTo(outputStream)

        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("files", file.name, requestBody)


//        val httpClient=OkHttpClient.Builder()
//        val interceptor:HttpLoggingInterceptor()
//        httpClient.addInterceptor(HttpLoggingInterceptor().apply { level=HttpLoggingInterceptor.Level.BODY
//        return OkHttpClient.Builder().addInterceptor(
//            OAuthInterceptor(
//                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0N2RjZTdlYmRiMzFiMzhmMThlZjE5MSIsImlhdCI6MTcwNTk5MTUwNywiZXhwIjoxNzA2MDc3OTA3fQ.3RyLlBIgmRJjRgCBWA1iAJY9jQmDRalzXupd_rgLE0s"))
//            .addInterceptor(interceptor)
//
//
//        })


        fun providesOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(
                OAuthInterceptor(
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0MWM0ZDUwNGJhYjk2MGU1Mjk3YjI4NiIsImlhdCI6MTcwNjA3NzE5MCwiZXhwIjoxNzA2MTYzNTkwfQ.D4fuKLfbcn3hcW-OKbgF35lQVnI9codHqKK9QcFc4ms",
                    )
            )
                .addInterceptor(interceptor)
                .build()
        }

        val httpClient = OkHttpClient()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://staging-app-uon.tepia.dev/api/v1/collections/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(providesOkHttpClient())
            .build()
            .create(UploadeService::class.java)




        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.uploadImage(part)

            Log.d("ImageUpload", response.toString())
        }
    }
}