package com.example.taskandroid.RecyclerView


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.taskandroid.R
import java.util.Collections
import java.util.Random

class RecyclerView : AppCompatActivity() {


    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var appRV: RecyclerView
    lateinit var appRVAdapter: AppRVAdapter
    lateinit var appList: ArrayList<AppRVModal>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        swipeRefreshLayout = findViewById(R.id.container)
        appRV = findViewById(R.id.idRVApp)

        appList = ArrayList()
        appRVAdapter = AppRVAdapter(appList, this)
        appRV.adapter = appRVAdapter


        appList.add(AppRVModal("Facebook ", R.drawable.facebook))
        appList.add(AppRVModal("Instagram", R.drawable.instra))
        appList.add(AppRVModal("Whatsapp", R.drawable.whatsapp))
        appList.add(AppRVModal("Snapchat", R.drawable.snap))
        appList.add(AppRVModal("Youtube", R.drawable.youtube))

        appRVAdapter.notifyDataSetChanged()

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(appList, Random(System.currentTimeMillis()))

            appRVAdapter.notifyDataSetChanged()

        }
    }

}