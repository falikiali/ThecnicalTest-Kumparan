package com.example.thecnicaltest_kumparan.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String,
    val id: Int,
    val name: String,
    val company: String
) : Parcelable
