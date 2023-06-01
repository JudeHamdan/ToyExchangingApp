package com.example.project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) : SQLiteOpenHelper(context,"Toy",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(NAME TEXT NOT NULL, LASTNAME TEXT NOT NULL, EMAIL TEXT NOT NULL UNIQUE, PASSWORD TEXT NOT NULL, CONTACT TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades if needed
        db?.execSQL("DROP TABLE IF EXISTS USERS")
        onCreate(db)
    }



}



