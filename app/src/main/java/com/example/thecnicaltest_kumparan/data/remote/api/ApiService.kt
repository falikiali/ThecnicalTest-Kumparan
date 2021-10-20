package com.example.thecnicaltest_kumparan.data.remote.api

import com.example.thecnicaltest_kumparan.data.remote.responses.CommentResponseItem
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponsesItem>

    @GET("users")
    suspend fun getUsers(): List<UserResponsesItem>

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<CommentResponseItem>

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): UserResponsesItem
}