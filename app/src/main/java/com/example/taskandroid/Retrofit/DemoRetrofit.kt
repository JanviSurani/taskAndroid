package com.example.taskandroid.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.taskandroid.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

  const val BASE_URL="https://jsonplaceholder.typicode.com/"
class DemoRetrofit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_retrofit)

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData= retrofitBuilder.getData()

        retrofitData.enqueue(object :Callback<List<MyDataItem>?>{
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {
                val responseBody=response.body()!!
                val myStringBuilder=StringBuilder()
                for (myData in responseBody){
                    myStringBuilder.append("\n",myData.id,"\n",myData.title,"\n",myData.body,"\n",myData.userId,"\n")
//                    myStringBuilder.append("\n")
//                    myStringBuilder.append(myData.title)
//                    myStringBuilder.append("\n")
//                    myStringBuilder.append(myData.userId)
//                    myStringBuilder.append("\n\n")

               }
             val txtId=findViewById<TextView>(R.id.txtId)
//             val txtTitle=findViewById<TextView>(R.id.txtTitle)
                txtId.text=myStringBuilder
//                txtTitle.text=myStringBuilder
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("demo", "onFailure: "+t.message)
            }

        })
    }}