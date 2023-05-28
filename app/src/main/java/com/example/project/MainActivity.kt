package com.example.project

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var rs= contentResolver.query(Database.CONTENT_URI, arrayOf(Database.ID,Database.NAME,Database.MEANING),null,null)




        var helper=MyHelper(applicationContext)

        var db = helper.readableDatabase





        val btnLogin:Button=findViewById(R.id.btnUserLogin)
        val btnSignup:Button=findViewById(R.id.btnUserSignup)

        btnLogin.setOnClickListener(){view->

            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)

        }
        btnSignup.setOnClickListener(){view->
            val intent =Intent(this@MainActivity,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}