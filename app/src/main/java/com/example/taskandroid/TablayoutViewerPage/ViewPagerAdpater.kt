package com.example.taskandroid.TablayoutViewerPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class ViewPagerAdpater(var img:List<Int>): RecyclerView.Adapter<ViewPagerAdpater.PageViewHolder>() {

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView =itemView.findViewById(R.id.music_app)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return  PageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.imgs,parent,false))
    }


    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.imageView.setImageResource(img[position])

    }

    override fun getItemCount(): Int {
            return img.size
    }

}