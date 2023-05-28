package com.example.project

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.example.project.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirm: EditText
    private lateinit var contactNum: EditText
    private lateinit var btnRegister: Button

    private lateinit var firstnameWrapper: TextInputLayout
    private lateinit var lastnameWrapper: TextInputLayout
    private lateinit var emailWrapper: TextInputLayout
    private lateinit var passwordWrapper: TextInputLayout
    private lateinit var confirmWrapper: TextInputLayout
    private lateinit var contactNumWrapper: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        firstname= findViewById(R.id.userFirstName)
        lastname= findViewById(R.id.userLastName)
        email= findViewById(R.id.userEmailAddress)
        password= findViewById(R.id.userPassword)
        confirm= findViewById(R.id.userconfPassword)
        contactNum= findViewById(R.id.userContactNumber)
        btnRegister=findViewById(R.id.btnRegister)

        firstnameWrapper= findViewById(R.id.userFirstNameWrapper)
        lastnameWrapper= findViewById(R.id.lastNameWrapper)
        emailWrapper= findViewById(R.id.userEmailAddressWrapper)
        passwordWrapper= findViewById(R.id.passwordWrapper)
        confirmWrapper= findViewById(R.id.confPasswordWrapper)
        contactNumWrapper= findViewById(R.id.contactWrapper)

        var rs= contentResolver.query(UsersProvider.CONTENT_URI,
            arrayOf(UsersProvider.name,UsersProvider.lastName,UsersProvider.email, UsersProvider.password,UsersProvider.contacct),
            null,
            null,
            null)

        btnRegister.setOnClickListener {

            val firstNameStr : String = firstname.text.toString().trim()
            val lastNameStr : String = lastname.text.toString().trim()
            val emailStr : String = email.text.toString().trim()
            val passwordStr : String = password.text.toString().trim()
            val confirmPasswordStr : String = confirm.text.toString().trim()
            val contactNumStr : String = contactNum.text.toString().trim()

            //check if one of the edit texts is empty
            if(firstNameStr.isEmpty()){
                firstnameWrapper.error = "Error: Enter First name"
                firstnameWrapper.requestFocus()
                return@setOnClickListener
            }

            if(lastNameStr.isEmpty()){
                lastnameWrapper.error = "Error: Enter Last name"
                lastnameWrapper.requestFocus()
                return@setOnClickListener
            }

            if(emailStr.isEmpty()){
                emailWrapper.error = "Error: Enter Email"
                emailWrapper.requestFocus()
                return@setOnClickListener
            }

            if(passwordStr.isEmpty()){
                passwordWrapper.error = "Error: Enter Password"
                passwordWrapper.requestFocus()
                return@setOnClickListener
            }

            if(confirmPasswordStr.isEmpty()){
                confirmWrapper.error = "Error: Confirm Password"
                confirmWrapper.requestFocus()
                return@setOnClickListener
            }
            if(passwordStr!=confirmPasswordStr){
                confirmWrapper.error="Error: Password didn't match"
                confirmWrapper.requestFocus()
                return@setOnClickListener

            }
            if(contactNumStr.isEmpty()){
                contactNumWrapper.error = "Error: Enter Phone Number"
                contactNumWrapper.requestFocus()
                return@setOnClickListener

            }


            var cv= ContentValues()

            cv.put(UsersProvider.name,firstNameStr)
            cv.put(UsersProvider.lastName,lastNameStr)
            cv.put(UsersProvider.email,emailStr)
            cv.put(UsersProvider.password,passwordStr)
            cv.put(UsersProvider.contacct,contactNumStr)


            contentResolver.insert(UsersProvider.CONTENT_URI,cv)
            rs?.requery()

            Toast.makeText(this,"Welcome to our community",Toast.LENGTH_SHORT).show()
            //add the next intent

        }



    }


}