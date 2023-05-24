package com.example.project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

@Suppress("UNREACHABLE_CODE")
class MyHelper(context: Context?) : SQLiteOpenHelper(context,"ABC",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
        db?.execSQL("CREATE TABLE NAME(_ID INT)")
        db?.execSQL("INSERT INTO NAME(NAME,MEANING) VALUES('taya','ahmad')")


        db?.execSQL( "CREATE TABLE NAME ( _id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, MEANING TEXT) ")
        db?.execSQL ( "INSERT INTO NAME (NAME, MEANING) VALUES (' MCA', 'Master of Computer Applications') ")
        db?.execSQL (  "INSERT INTO NAME (NAME, MEANING) VALUES (' BCA, | Bachlor of Computer Applications')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}

