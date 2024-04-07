package com.example.taskandroid.DemoMVVM

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.Model.Responcerepo

import com.example.taskandroid.Viewmodel.DemoMvvmViewModel
import com.example.taskandroid.Adpater.RecyclerViewAdpater
import com.example.taskandroid.R


class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter:RecyclerViewAdpater

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
         return  view
    }
    private  fun initViewModel(view:View){
        val recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        val decoration=DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        recyclerAdapter=RecyclerViewAdpater()
        recyclerView.adapter=recyclerAdapter


    }
    @SuppressLint("FragmentLiveDataObserve")
    private  fun initViewModel(){
        val viewModel=ViewModelProvider(this).get(DemoMvvmViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(this,Observer<Responcerepo>{
            if (it!=null){
                recyclerAdapter.setUpdatedData(it.items)
            }else{
                Toast.makeText(activity,"Failure in getting Data",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()

    }
    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }
}