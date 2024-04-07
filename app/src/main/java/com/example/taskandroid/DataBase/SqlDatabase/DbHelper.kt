package com.example.taskandroid.DataBase.SqlDatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.Locale.Category

class DbHelper(var ctx:Context) : SQLiteOpenHelper(ctx,"My Datbase",null,1) {


    override fun onCreate(db: SQLiteDatabase?) {
        var create_table = "CREATE TABLE CATOGERIES (_Id INTEGER PRIMARY KEY AUTOINCREMENT , NAME STRING,IMAGE BLOB)"
        db?.execSQL(create_table)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
//
//    fun insertData(catogeries:Categories,db:SQLiteDatabase)
//    {
//        var dbHelper = this.writableDatabase
//        var value = ContentValues()
//        value.put("Name",catogeries.name)
//        value.put("Image",catogeries.Image)
//        db.insert("Catogeries",null,value)
//    }
}