package com.example.taskandroid.GridView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class Adpater(var list: List<DataModel>): RecyclerView.Adapter<Adpater.Viewholder>() {


    class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var text_value=itemView.findViewById<TextView>(R.id.text_value)
        var imageview=itemView.findViewById<ImageView>(R.id.imageview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.text_value.text=list[position].text

        holder.imageview.setImageResource(list[position].image_id)
    }
}