package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity


class ShopActivity : AppCompatActivity() {
    private lateinit var imgBanner: ViewFlipper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        imgBanner = findViewById(R.id.imgBanner)

        val sliders = intArrayOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4,
            R.drawable.banner5,
        )

        for (slide in sliders) {
            bannerFlipper(slide)
        }
    }

    private fun bannerFlipper(image: Int) {
        val imageView = ImageView(this)
        imageView.setImageResource(image)
        imgBanner.addView(imageView)
        imgBanner.setFlipInterval(2000)
        imgBanner.isAutoStart = true
        imgBanner.setInAnimation(this, android.R.anim.fade_in)
        imgBanner.setOutAnimation(this, android.R.anim.fade_out)
    }

    fun onImageClick(view: View) {
        val clickedImageViewId = view.id

        val intent: Intent = when (clickedImageViewId) {
            R.id.babyID -> Intent(this, babyActivity::class.java)
            R.id.vehiclesID -> Intent(this, vehicleActivity::class.java)
            R.id.artsID -> Intent(this,ArtActivity::class.java)
            R.id.buildingID -> Intent(this,buildingActivity::class.java)
            else -> return
        }

        startActivity(intent)
    }

}

