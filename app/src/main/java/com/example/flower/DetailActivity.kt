package com.example.flower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val flowerName = intent.getStringExtra("name")
        val flowerDescription = intent.getStringExtra("description")
        val flowerPhoto = intent.getIntExtra("photo", 0)

        val tvName: TextView = findViewById(R.id.tv_flower_name_detail)
        val tvDescription: TextView = findViewById(R.id.tv_flower_description_detail)
        val imgPhoto: ImageView = findViewById(R.id.img_flower_detail)

        tvName.text = flowerName
        tvDescription.text = flowerDescription
        imgPhoto.setImageResource(flowerPhoto)
    }
}
