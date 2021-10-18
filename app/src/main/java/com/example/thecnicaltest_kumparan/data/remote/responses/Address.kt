package com.example.thecnicaltest_kumparan.data.remote.responses

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)