package com.example.thecnicaltest_kumparan.data.remote.responses

data class UserResponsesItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)