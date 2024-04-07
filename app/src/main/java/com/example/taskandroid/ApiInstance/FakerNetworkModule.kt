package com.example.taskandroid.ApiInstance

import com.example.taskandroid.Api.fakerApi
import com.example.taskandroid.ApiInstance.Constants.BaseURL
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


object Constants{
    const val BaseURL="https://fakestoreapi.com/"
}


@DisableInstallInCheck
//@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit):fakerApi{
        return  retrofit.create(fakerApi::class.java)
    }
}