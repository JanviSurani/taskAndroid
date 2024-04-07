package com.example.taskandroid.Network.postapi

import com.example.taskandroid.Model.Responcelogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiService {
    @FormUrlEncoded
    @POST("sign_in")
    fun loginAsync(
        @Field("email") email: String,
        @Field("password") password: String,
    ):Call<Responcelogin>

}