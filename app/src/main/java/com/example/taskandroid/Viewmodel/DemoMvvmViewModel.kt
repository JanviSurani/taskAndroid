package com.example.taskandroid.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskandroid.Model.Responcerepo
import com.example.taskandroid.Network.getapi.RetroInstance
import com.example.taskandroid.Network.getapi.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DemoMvvmViewModel:ViewModel (){

    var recyclerListLiveData:MutableLiveData<Responcerepo>

     init {
         recyclerListLiveData= MutableLiveData()
     }

    fun getRecyclerListObserver():MutableLiveData<Responcerepo>{
        return  recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance= RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response=retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)

        }
    }
}