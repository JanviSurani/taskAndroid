//package com.example.taskandroid
//
//import android.content.ContentValues
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//
//class DatabaseSqlDemo : AppCompatActivity() {
//    val  button=findViewById< Button>(R.id.button)
//    val editText=findViewById<EditText>(R.id.edittext)
//    val editText2=findViewById<EditText>(R.id.edittext2)
//    val  btnRead=findViewById< Button>(R.id.btnRead)
//    val  tvResult=findViewById<TextView>(R.id.tvResult)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_database_sql_demo)
//        val context = this
//        val db =MyDBHelper(context)
////        var helper=MyDBHelper(applicationContext)
////        var db=helper.readableDatabase
////        var rs=db.rawQuery("SELECT*FROM USERS",null)
////
////        if (rs.moveToNext())
////
////            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_LONG).show()
//
//
////
////        button.setOnClickListener {
////            var cv=ContentValues()
////            cv.put("UNAME",editText.text.toString())
////            cv.put("PWD",editText2.text.toString())
////            db.insert("USERS",null,cv)
////
////
////            editText.setText("")
////            editText2.setText("")
////            editText.requestFocus()
////        }
//        button.setOnClickListener {
//            if (editText.text.toString().isNotEmpty() &&
//                editText2.text.toString().isNotEmpty()
//            ) {
//                val user = User(editText.text.toString(), editText2.text.toString().toInt())
//                db.insertData(user)
//                clearField()
//            }
//            else {
//                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//
////        btnRead.setOnClickListener {
////            val data = db.readData()
////            tvResult.text = ""
////            for (i in 0 until data.size) {
////                tvResult.append(
////                    data[i].id.toString() + " " + data[i].name + " " + data[i].pwd + ""
////                )
////            }
////        }
//
//    }
//    private fun clearField() {
//        editText.text.clear()
//        editText2.text.clear()
//    }
//    }
