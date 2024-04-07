package com.example.taskandroid.Network.postapi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

object InstanceRetro {
  fun getRetroInstance(): Retrofit {
   return Retrofit.Builder()
     .baseUrl(Constant.BaseURL)
     .client(mOkHttpClient)
     .addConverterFactory(GsonConverterFactory.create())
     .build()
  }

  object Constant {
    const val BaseURL="http://www.theappvvm.com/api/"
  }


  var mHttpLoggingInterceptor = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)

  var mOkHttpClient = OkHttpClient
    .Builder()
    .addInterceptor(mHttpLoggingInterceptor)
    .build()
}