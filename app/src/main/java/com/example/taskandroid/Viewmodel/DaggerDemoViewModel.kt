package com.example.taskandroid.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskandroid.Api.NetworkResult
import com.example.taskandroid.Model.Country
//import com.example.taskandroid.Api.doOnFailure
//import com.example.taskandroid.Api.doOnSuccess
import com.example.taskandroid.domain.usecase.CountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DaggerDemoViewModel @Inject constructor(private val countryUseCase: CountryUseCase):ViewModel() {
    val _counry = MutableLiveData<State>()
    val counry: LiveData<State>
        get() = _counry
    init {
        getAllCountries()
    }

    private fun getAllCountries() = viewModelScope.launch {
        val result = countryUseCase.invoke()

        when(result.value){
            is NetworkResult.Success -> {
                _counry.value = State(data = result.value?.data)

            }

            is NetworkResult.Error->{
                _counry.value =State(error ="Couldn't reach server, check your internet connection.")
            }

            else->{
                _counry.value =State(error ="Couldn't reach server, check your internet connection.")

            }
        }
    }
}

data class State(

    val loading:Boolean=false,
    val data:Country?=null,
    val error: String ?=null

)
