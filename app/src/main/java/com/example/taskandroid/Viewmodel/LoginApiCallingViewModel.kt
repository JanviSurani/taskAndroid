package com.example.taskandroid.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskandroid.Model.Data
import com.example.taskandroid.Model.Responcelogin
import com.example.taskandroid.Network.postapi.ApiService
import com.example.taskandroid.Network.postapi.InstanceRetro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginApiCallingViewModel : ViewModel() {

  var  createNewUserLiveData: MutableLiveData<Responcelogin?>

    init {
        createNewUserLiveData= MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<Responcelogin?> {
        return  createNewUserLiveData
    }

    fun createNewUser(data: Data){

        val retroService= InstanceRetro.getRetroInstance().create(ApiService::class.java)
        var call=retroService.loginAsync(email = data.email, password = data.password)
        call.enqueue(object :Callback<Responcelogin>{
            override fun onResponse(call: Call<Responcelogin>, response: Response<Responcelogin>) {
                    if (response.isSuccessful){
                        createNewUserLiveData.postValue(response.body())
                    }else{
                        createNewUserLiveData.postValue(null)
                    }
            }

            override fun onFailure(call: Call<Responcelogin>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

        })
    }
}