package com.dicoding.mysdgapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sdgs(
    val number: String,
    val name: String,
    val type: String,
    val explanation: String,
    val description: String,
    val photo: String,
    val bgPhoto: String
) : Parcelable