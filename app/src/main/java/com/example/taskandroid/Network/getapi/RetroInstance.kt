package com.example.taskandroid.Network.getapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetroInstance {
    companion object{
        val intercepter = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(intercepter)
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(25,TimeUnit.SECONDS)
        }.build()


        val BASE_URL="https://api.github.com/search/"
        fun getRetroInstance():Retrofit{
            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

    }


}