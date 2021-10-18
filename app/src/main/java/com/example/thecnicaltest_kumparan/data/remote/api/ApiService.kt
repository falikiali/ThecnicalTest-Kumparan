package com.example.thecnicaltest_kumparan.data.remote.api

import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): List<PostResponsesItem>

    @GET("users")
    fun getUsers(): List<UserResponsesItem>
}