package com.example.project

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

private lateinit var email: EditText
private lateinit var password: EditText
private lateinit var loginBtn : Button

private lateinit var emailWrapper: TextInputLayout
private lateinit var passwordWrapper: TextInputLayout
class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email= findViewById(R.id.userEmail)
        password= findViewById(R.id.userPassword)
        loginBtn=findViewById(R.id.loginBtn)

        emailWrapper= findViewById(R.id.userEmailWrapper)
        passwordWrapper= findViewById(R.id.userPasswordWrapper)

        val cols = listOf<String>(UsersProvider.email,UsersProvider.password).toTypedArray()

        var rs= contentResolver.query(UsersProvider.CONTENT_URI,
            cols,
            null,
            null,
            cols[0])

        loginBtn.setOnClickListener {
            val emailStr : String = email.text.toString().trim()
            val passwordStr : String = password.text.toString().trim()

            //check if one of the edit texts is empty
            if(emailStr.isEmpty()){
                emailWrapper.error = "Error: Enter Your Email"
                emailWrapper.requestFocus()
                return@setOnClickListener
            }

            if(passwordStr.isEmpty()){
                passwordWrapper.error = "Error: Enter Your Password"
                passwordWrapper.requestFocus()
                return@setOnClickListener
            }

            when(rs?.count){
                //if an error happened while the running
                null -> {Toast.makeText(this,"Error while running the query",Toast.LENGTH_SHORT).show()}
                //if there is no records inserted
                0 -> {Toast.makeText(this,"No users in the database!",Toast.LENGTH_SHORT).show()}
                else -> {
                    if(rs != null){
                        if(rs?.moveToFirst() == true){
                            do{
                                val email : String = rs.getString(rs.getColumnIndex(UsersProvider.email))
                                val password : String = rs.getString(rs.getColumnIndex(UsersProvider.password))
                                if(email == emailStr && password == passwordStr){
                                    //go to the next intent
                                    Toast.makeText(this,"Welcome "+UsersProvider.name,Toast.LENGTH_SHORT).show()
                                }

                            }while (rs.moveToNext())

                            Toast.makeText(this,"No such user! please register to join our community",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }
}