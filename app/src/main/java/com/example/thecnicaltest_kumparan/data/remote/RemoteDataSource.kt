package com.example.thecnicaltest_kumparan.data.remote

import com.example.thecnicaltest_kumparan.data.remote.responses.*

interface RemoteDataSource {
    suspend fun getAllPost(): List<PostResponseItem>
    suspend fun getAllUser(): List<UserResponseItem>
    suspend fun getUser(userId: Int): UserResponseItem
    suspend fun getComment(postId: Int): List<CommentResponseItem>
    suspend fun getAlbum(userId: Int): List<AlbumResponseItem>
    suspend fun getPhoto(albumId: Int): List<PhotoResponseItem>
}