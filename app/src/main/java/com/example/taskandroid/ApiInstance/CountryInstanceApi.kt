package com.example.taskandroid.ApiInstance

import com.example.taskandroid.Api.CountryApi
import com.example.taskandroid.Repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


val BASE_URL="https://raw.githubusercontent.com/"


@Module
@InstallIn(SingletonComponent::class)
object Appmodule {

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit):CountryApi{
        return retrofit.create(CountryApi::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}