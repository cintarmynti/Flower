package com.example.flower

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFlowers: RecyclerView  // Ganti rvHeroes menjadi rvFlowers
    private val list = ArrayList<Flower>()  // Ganti Hero menjadi Flower

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFlowers = findViewById(R.id.rv_flowers)  // Ganti ID di sini
        rvFlowers.setHasFixedSize(true)

        list.addAll(getListFlowers())
        showRecyclerList()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val iconProfile: ImageView = findViewById(R.id.icon_profile)
        iconProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListFlowers(): ArrayList<Flower> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFlower = ArrayList<Flower>()  // Ganti listHero menjadi listFlower
        for (i in dataName.indices) {
            val flower = Flower(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))  // Ganti Hero menjadi Flower
            listFlower.add(flower)
        }
        dataPhoto.recycle()  // Jangan lupa untuk membebaskan array yang diperoleh
        return listFlower
    }

    private fun showRecyclerList() {
        rvFlowers.layoutManager = GridLayoutManager(this, 2)  // Mengubah menjadi 2 kolom
        val listFlowerAdapter = ListFlowerAdapter(list)
        rvFlowers.adapter = listFlowerAdapter
    }
}
