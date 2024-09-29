package com.example.flower

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)

        val flowerName = intent.getStringExtra("name")
        val flowerDescription = intent.getStringExtra("description")
        val flowerPhoto = intent.getIntExtra("photo", 0)
        val flowerSeason = intent.getStringExtra("season")
        val flowerOrigin = intent.getStringExtra("origin")
        val flowerLatin = intent.getStringExtra("latin")
        val flowerSymbol = intent.getStringExtra("symbol")

        val tvName: TextView = findViewById(R.id.tv_flower_name_detail)
        val tvDescription: TextView = findViewById(R.id.tv_flower_description_detail)
        val tvSeason: TextView = findViewById(R.id.tv_flower_season)
        val tvOrigin: TextView = findViewById(R.id.tv_flower_origin)
        val tvSymbol: TextView = findViewById(R.id.tv_flower_symbol)
        val tvLatin: TextView = findViewById(R.id.tv_flower_latin)
        val imgPhoto: ImageView = findViewById(R.id.img_flower_detail)

        tvName.text = flowerName
        tvDescription.text = flowerDescription
        tvSeason.text = flowerSeason
        tvOrigin.text = flowerOrigin
        tvLatin.text = flowerLatin
        tvSymbol.text = flowerSymbol
        imgPhoto.setImageResource(flowerPhoto)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
