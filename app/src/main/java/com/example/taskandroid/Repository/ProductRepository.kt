package com.example.taskandroid.Repository


import androidx.lifecycle.MutableLiveData
import com.example.taskandroid.Api.fakerApi
import com.example.taskandroid.Model.Product
import javax.inject.Inject

class ProductRepository@Inject constructor(private val fakerAPI: fakerApi) {
    private val _products = MutableLiveData<Product>()
    val products: MutableLiveData<Product>
        get() = _products

    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }
    }
}