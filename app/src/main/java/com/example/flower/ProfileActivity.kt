package com.example.flower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvUserName: TextView = findViewById(R.id.tv_user_name)
        val imgProfile: ImageView = findViewById(R.id.img_user_profile)

        // Ganti sesuai dengan nama pengguna dan gambar profil yang diinginkan
        tvUserName.text = "Cinta Ramayanti"
        imgProfile.setImageResource(R.drawable.profile_picture)
    }
}
