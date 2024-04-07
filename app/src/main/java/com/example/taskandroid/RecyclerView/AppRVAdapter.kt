package com.example.taskandroid.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class AppRVAdapter (
    private val AppList: ArrayList<AppRVModal>,
    private val context: Context
    ) : RecyclerView.Adapter<AppRVAdapter.AppViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): AppViewHolder {

            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.app_rv_item,
                parent, false
            )

            return AppViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: AppViewHolder, position: Int) {

            holder.appNameTV.text = AppList.get(position).appName
            holder.appIV.setImageResource(AppList.get(position).appImg)
        }

        override fun getItemCount(): Int {

            return AppList.size
        }

        class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val appNameTV: TextView = itemView.findViewById(R.id.idTVApp)
            val appIV: ImageView = itemView.findViewById(R.id.idIVApp)
        }


}