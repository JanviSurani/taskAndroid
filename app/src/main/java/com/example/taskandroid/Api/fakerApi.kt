package com.example.taskandroid.Api

import com.example.taskandroid.Model.Product
import retrofit2.Response
import retrofit2.http.GET

interface fakerApi {

    @GET("products")
     suspend fun getProducts():Response<Product>
}