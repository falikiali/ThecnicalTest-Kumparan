package com.example.thecnicaltest_kumparan.data.remote.api

import com.example.thecnicaltest_kumparan.data.remote.responses.*
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponseItem>

    @GET("users")
    suspend fun getUsers(): List<UserResponseItem>

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<CommentResponseItem>

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): UserResponseItem

    @GET("users/{userId}/albums")
    suspend fun getAlbums(@Path("userId") userId: Int): List<AlbumResponseItem>

    @GET("photos")
    suspend fun getPhotos(): List<PhotoResponseItem>
}