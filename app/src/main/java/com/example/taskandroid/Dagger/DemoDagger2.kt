package com.example.taskandroid.Dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.taskandroid.R
import com.example.taskandroid.Viewmodel.DemoDagger2ViewModel
import com.example.taskandroid.Viewmodel.DemoDagger2Factory
import com.example.taskandroid.FakerApplication
import javax.inject.Inject

class DemoDagger2 : AppCompatActivity() {

    lateinit var demoDagger2ViewModel: DemoDagger2ViewModel
//    private val demoDagger2ViewModel : DemoDagger2ViewModel by viewModels()

    @Inject
   lateinit var demoDagger2Factory:DemoDagger2Factory
    private val products: TextView
        get() = findViewById(R.id.products)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_dagger2)

       (application as FakerApplication).applicationComponent.inject(this)

        demoDagger2ViewModel=ViewModelProvider(this,demoDagger2Factory).get(DemoDagger2ViewModel::class.java)

        demoDagger2ViewModel.productsLiveData.observe(this, Observer {
            products.text =  it.joinToString { x -> x.title + "\n\n" }
        })
    }
    }
