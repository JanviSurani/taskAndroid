package com.example.taskandroid.Adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.Model.Item
import com.example.taskandroid.R
import com.squareup.picasso.Picasso

class RecyclerViewAdpater :RecyclerView.Adapter<RecyclerViewAdpater.MyViewholder>(){

    var items=ArrayList<Item>()
    
    fun setUpdatedData(items: List<Item?>?){
        this.items= items as ArrayList<Item>
        notifyDataSetChanged()
    }


    class MyViewholder (view: View):RecyclerView.ViewHolder(view){
           val imageThumb=view.findViewById<ImageView>(R.id.imageThumb)
           val tvTitle=view.findViewById<TextView>(R.id.tvTitle)
           val tvDesc=view.findViewById<TextView>(R.id.tvDesc)
                    fun bind(data: Item){
                        tvTitle.text=data.name
                        tvDesc.text=data.description

                        val url=data.owner?.avatar_url
                        Picasso.get()
                            .load(url)
                            .into(imageThumb)

                    }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row,parent,false)
        return  MyViewholder(view)
    }

    override fun getItemCount(): Int {
        return  items.size

    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
            holder.bind(items.get(position))
    }
}