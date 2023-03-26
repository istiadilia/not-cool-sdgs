package com.dicoding.mysdgapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sdgs(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable