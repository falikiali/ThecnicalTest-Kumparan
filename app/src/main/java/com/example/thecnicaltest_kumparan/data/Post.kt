package com.example.thecnicaltest_kumparan.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val userId: Int,
    val userName: String,
    val userCompany: String,
    val title: String,
    val body: String
) : Parcelable