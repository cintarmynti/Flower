package com.example.flower

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flower(
    var name: String,
    var description: String,
    var photo: Int,
    var season: String,
) : Parcelable
