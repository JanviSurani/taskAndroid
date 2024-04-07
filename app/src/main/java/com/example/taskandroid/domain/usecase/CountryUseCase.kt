package com.example.taskandroid.domain.usecase


import androidx.lifecycle.LiveData
import com.example.taskandroid.Api.NetworkResult
import com.example.taskandroid.Model.Country
//import com.example.taskandroid.Api.NetworkResult
//import com.example.taskandroid.Api.map
import com.example.taskandroid.Model.CountryItem
import com.example.taskandroid.Repository.CountryRepository

import com.example.taskandroid.domain.mapper.CountryMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject


class CountryUseCase @Inject constructor (
    private val countryRepository: CountryRepository,
//    private val countryMapper: CountryMapper
) {

   suspend operator fun invoke(): LiveData<NetworkResult<Country>> {
       return countryRepository.getCountry()
    }


//    suspend fun getCountry(): Flow<NetworkResult<List<CountryItem>?>> {
//        return countryRepository.getCountry().map {result->
//            result.map{
//                countryMapper.mapFrom(it)
//            }
//        }
//    }
}