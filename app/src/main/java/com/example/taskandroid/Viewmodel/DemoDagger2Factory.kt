package com.example.taskandroid.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskandroid.Repository.ProductRepository
import javax.inject.Inject

class DemoDagger2Factory @Inject constructor(private val repository: ProductRepository) :ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DemoDagger2ViewModel(repository) as T
    }
}