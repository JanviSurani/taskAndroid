package com.example.taskandroid.Adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.Model.Country
import com.example.taskandroid.R


class CountryAdpater(private val dataSet:Country):
   RecyclerView.Adapter<CountryAdpater.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
       val name:TextView
       val region:TextView

       init {
           name=view.findViewById(R.id.name)
           region=view.findViewById(R.id.region)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view=LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.row_item,viewGroup,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text= dataSet[position].name
        viewHolder.region.text=dataSet[position].region

    }

    override fun getItemCount()=dataSet.size
}