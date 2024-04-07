package com.example.taskandroid.Repository

//import com.example.taskandroid.Api.NetworkResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.taskandroid.Api.CountryApi
import com.example.taskandroid.Api.NetworkResult
import com.example.taskandroid.Model.Country
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val api: CountryApi
)
//    : BaseRepository(),CountryRepository
{

//    suspend fun  getCountries()=api.getAllCountries()

     suspend fun getCountry(): LiveData<NetworkResult<Country>> {
        val response = api.getAllCountries()
//        return if (response.isSuccessful) {
//            NetworkResult.success(value = response.body() ?: Country())
//        } else
//            NetworkResult.failure(exception = Throwable())
         return liveData {
             if (response.isSuccessful){
                 emit(
                     NetworkResult.Success(data = response.body() ?: Country())
                 )
             }else{
                 emit(
                     NetworkResult.Error(message = response.message())
                 )
             }
         }
    }
}