package com.example.taskandroid.Network.getapi


import com.example.taskandroid.Model.Responcerepo
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q")query :String): Responcerepo
}