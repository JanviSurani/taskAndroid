package com.example.taskandroid.Api

import com.example.taskandroid.Model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    suspend fun getAllCountries(): Response<Country>
}