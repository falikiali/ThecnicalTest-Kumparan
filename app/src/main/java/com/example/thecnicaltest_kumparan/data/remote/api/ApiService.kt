package com.example.thecnicaltest_kumparan.data.remote.api

import com.example.thecnicaltest_kumparan.data.remote.responses.CommentResponseItem
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponsesItem>

    @GET("users")
    suspend fun getUsers(): List<UserResponsesItem>

    @GET("comments")
    suspend fun getComments(): List<CommentResponseItem>
}