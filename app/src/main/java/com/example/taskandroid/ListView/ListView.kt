package com.example.taskandroid.ListView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityListViewBinding

class ListView : AppCompatActivity() {


    private lateinit var binding:ActivityListViewBinding
    private lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val imageId= intArrayOf(
            R.drawable.sahid,R.drawable.ranveer,R.drawable.sushant,R.drawable.prabhas,
            R.drawable.shahrukh,R.drawable.varun,R.drawable.viky,R.drawable.tiger
        )
        val name= arrayOf(
            "Sahid","Ranveer","Sushant","Prabhas","Shahrukh","Varun","Viky","Tiger"
        )
        val lastMessage= arrayOf(
            "hye","hru","idn","do't disturb","shutup","Go Ahed","dinner?","lunch","weekend"
        )
        val lastmsgTime= arrayOf(
            "8:55 pm","9:55 am","10:56 pm","9:00 am","2:00 pm","8:00 pm","7:00pm","3:00pm","8:00pm"
        )
        val phoneNo= arrayOf(
            "5236987412","5522523655","5698741236","1236547856","52634178965","5896321474",
            "5852636945","4563217895","5247852136"
        )
        val country= arrayOf(
            "canada","austraila","london","USA","africa","california","philipines","chaina","germeny"
        )

        userArrayList=ArrayList()
            for (i in name.indices){
               val user=User(name [i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i])
                userArrayList.add(user)
            }
        binding.listView.isClickable=true
        binding.listView.adapter=MyAdpater(this,userArrayList)
        binding.listView.setOnItemClickListener{parent,view,position,id->

            val name=name[position]
            val phone=phoneNo[position]
            val country=country[position]
            val imageid=imageId[position]
            val i=Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("country",country)
            i.putExtra("imageId",imageId)
            startActivity(i)

        }





















//        val language:Array<String> = resources.getStringArray(R.array.technology_list)
//        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,language)
//
//
//        binding.listView.adapter = arrayAdapter
//        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
//            val selectedItem = adapterView.getItemAtPosition(position) as String
//            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
//
//            Toast.makeText(applicationContext,"click item $selectedItem its position $itemIdAtPos",Toast.LENGTH_SHORT).show()
//        }

}
}