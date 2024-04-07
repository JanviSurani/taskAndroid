package com.example.taskandroid.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskandroid.Model.Product
import com.example.taskandroid.Repository.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class DemoDagger2ViewModel  @Inject constructor(private val repository: ProductRepository) : ViewModel(){


    val productsLiveData : LiveData<Product>
        get() = repository.products

    init {
        viewModelScope.launch {
            delay(10000)
            repository.getProducts()
        }
    }
}