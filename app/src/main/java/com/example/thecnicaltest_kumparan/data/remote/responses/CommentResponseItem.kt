package com.example.thecnicaltest_kumparan.data.remote.responses

data class CommentResponseItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)