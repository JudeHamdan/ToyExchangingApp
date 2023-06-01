package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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