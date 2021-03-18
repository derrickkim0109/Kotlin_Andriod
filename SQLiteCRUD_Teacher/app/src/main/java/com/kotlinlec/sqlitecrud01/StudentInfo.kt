package com.kotlinlec.sqlitecrud01

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StudentInfo(context: Context?) : SQLiteOpenHelper(context, "StudentInfo.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, dept TEXT, phone TEXT);"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query = "DROP TABLE IF EXISTS student"
        db!!.execSQL(query)
        onCreate(db)
    }


}