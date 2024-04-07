package com.example.taskandroid.ImageUploadApi
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadeService {
    @Multipart
    @POST("upload_pictures")
    suspend fun uploadImage(
        @Part image:MultipartBody.Part
    ):ImageResponse
}