package com.example.thecnicaltest_kumparan.data.remote

import com.example.thecnicaltest_kumparan.data.remote.api.ApiService
import com.example.thecnicaltest_kumparan.data.remote.responses.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor (private val apiService: ApiService) : RemoteDataSource{
    override suspend fun getAllPost(): List<PostResponseItem> = apiService.getPosts()

    override suspend fun getAllUser(): List<UserResponseItem> = apiService.getUsers()

    override suspend fun getUser(userId: Int): UserResponseItem = apiService.getUser(userId)

    override suspend fun getComment(postId: Int) = apiService.getComments(postId)

    override suspend fun getAlbum(userId: Int): List<AlbumResponseItem> = apiService.getAlbums(userId)

    override suspend fun getPhoto(): List<PhotoResponseItem> = apiService.getPhotos()
}