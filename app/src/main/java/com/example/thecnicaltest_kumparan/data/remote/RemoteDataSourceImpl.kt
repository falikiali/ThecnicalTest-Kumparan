package com.example.thecnicaltest_kumparan.data.remote

import com.example.thecnicaltest_kumparan.data.remote.api.ApiService
import com.example.thecnicaltest_kumparan.data.remote.responses.CommentResponseItem
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor (private val apiService: ApiService) : RemoteDataSource{
    override suspend fun getAllPost(): List<PostResponsesItem> = apiService.getPosts()

    override suspend fun getAllUser(): List<UserResponsesItem> = apiService.getUsers()

    override suspend fun getUser(userId: Int): UserResponsesItem = apiService.getUser(userId)

    override suspend fun getComment(postId: Int) = apiService.getComments(postId)
}