//package com.example.taskandroid
//
//import android.content.Context
//import android.content.ContentValues
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.widget.Toast
//val DATABASENAME = "USERDB"
//val TABLENAME = "Users"
//val COL_NAME = "name"
//val COL_PWD = "pwd"
//val COL_ID = "id"
//
//class MyDBHelper(var context: Context) :SQLiteOpenHelper(context, DATABASENAME,null,1) {
//    override fun onCreate(db: SQLiteDatabase?) {
////            db?.execSQL("CREATE TABLE USERS (USERID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,PWD TEXT)")
////            db?.execSQL("INSERT INTO USERS (UNAME,PWD)VALUES('pcshukla@aits.edu.in','pcs')")
////            db?.execSQL("INSERT INTO USERS(UNAME,PWD)VALUES('parth@gmail.com','atmiya')")
//        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_PWD + " INTEGER)"
//        db?.execSQL(createTable)
//
//
//
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//
//    }
//
////    fun insertData(user: User) {
////        val database = this.writableDatabase
////        val contentValues = ContentValues()
////        contentValues.put(COL_NAME, user.name)
////        contentValues.put(COL_PWD, user.pwd)
////        val result = database.insert(TABLENAME, null, contentValues)
////        if (result == (0).toLong()) {
////            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
////        }
////        else {
////            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
////        }
////    }
////    fun readData(): MutableList<User> {
////        val list: MutableList<User> = ArrayList()
////        val db = this.readableDatabase
////        val query = "Select * from $TABLENAME"
////        val result = db.rawQuery(query, null)
////        if (result.moveToFirst()) {
////            do {
////                val user = User()
////                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
////                user.name = result.getString(result.getColumnIndex(COL_NAME))
////                user.pwd = result.getString(result.getColumnIndex(COL_PWD)).toInt()
////                list.add(user)
////            }
////            while (result.moveToNext())
////        }
////        return list
////    }
//}
//
