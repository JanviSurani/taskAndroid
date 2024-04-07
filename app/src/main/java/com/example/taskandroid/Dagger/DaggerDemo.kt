package com.example.taskandroid.Dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskandroid.Viewmodel.DaggerDemoViewModel
import com.example.taskandroid.Adpater.CountryAdpater
import com.example.taskandroid.Api.NetworkResult
import com.example.taskandroid.Model.Country
import com.example.taskandroid.databinding.ActivityDragerDemoBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DaggerDemo : AppCompatActivity() {

    private lateinit var binding:ActivityDragerDemoBinding
    private lateinit var adpater:CountryAdpater
    private  val viewModel:DaggerDemoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityDragerDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.counry.observe(this) { response ->

            if (response.error!=null){
                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }

            Log.d("TAG", "onCreate: ${response.data}")
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adpater = CountryAdpater(response.data ?: Country())
            binding.recyclerView.adapter = adpater
        }
    }
}
