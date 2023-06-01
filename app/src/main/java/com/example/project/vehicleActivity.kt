package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class vehicleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)
    }
    fun onImageClick(view: View) {
        // Check which image view was clicked based on its ID
        val clickedImageViewId = view.id
        val intent = Intent(this@vehicleActivity, checkoutActivity::class.java)
        // Pass any necessary data to the FinalActivity if needed
        // For example, you can pass the ID of the clicked image view
        intent.putExtra("clickedImageViewId", clickedImageViewId)
        startActivity(intent)
    }
}