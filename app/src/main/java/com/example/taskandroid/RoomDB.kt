package com.example.taskandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.widget.Toast
import android.util.Log
import kotlinx.coroutines.withContext
import androidx.databinding.DataBindingUtil
import com.example.taskandroid.databinding.ActivityRoomDbBinding


class RoomDB : AppCompatActivity() {


    private lateinit var binding: ActivityRoomDbBinding
    private lateinit var appDb: AppDatabase




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_db)
        appDb= AppDatabase.getDatabase(this)


        binding.btnWriteData.setOnClickListener {
            writeData()
        }
        binding.btnReadData.setOnClickListener {
            readData()
        }
        binding.btnDeleteAll.setOnClickListener {

            GlobalScope.launch {

                appDb.studentDao().deleteAll()

            }

        }
        binding.btnUpdateData.setOnClickListener{
            updateData()
        }

    }


    private fun writeData(){
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val rollNo = binding.etRollNo.text.toString()

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()     ) {
            val student = Student(
                null, firstName, lastName, rollNo.toInt()
            )
            GlobalScope.launch(Dispatchers.IO) {

                appDb.studentDao().insert(student)
            }

            binding.etFirstName.text?.clear()
            binding.etLastName.text?.clear()
            binding.etRollNo.text?.clear()

            Toast.makeText(this@RoomDB,"Successfully written",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this@RoomDB,"PLease Enter Data",Toast.LENGTH_SHORT).show()

    }
    private fun readData(){

        val rollNo = binding.etRollNoRead.text.toString()

        if (rollNo.isNotEmpty()){

            lateinit var student : Student

            GlobalScope.launch {

                student = appDb.studentDao().findByRoll(rollNo.toInt())
                Log.d("Robin Data",student.toString())
                displayData(student)

            }

        }else Toast.makeText(this@RoomDB,"Please enter the data", Toast.LENGTH_SHORT).show()

    }
    private fun updateData(){


        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val rollNo = binding.etRollNo.text.toString()

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()     ) {

            GlobalScope.launch(Dispatchers.IO) {

                appDb.studentDao().update(firstName,lastName,rollNo.toInt())
            }

            binding.etFirstName.text?.clear()
            binding.etLastName.text?.clear()
            binding.etRollNo.text?.clear()

            Toast.makeText(this@RoomDB,"Successfully updated",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this@RoomDB,"PLease Enter Data",Toast.LENGTH_SHORT).show()





    }

    private suspend fun displayData(student: Student){

        withContext(Dispatchers.Main){

            binding.tvFirstName.text = student.firstName
            binding.tvLastName.text = student.lastName
            binding.tvRollNo.text = student.rollNo.toString()

        }

    }

}