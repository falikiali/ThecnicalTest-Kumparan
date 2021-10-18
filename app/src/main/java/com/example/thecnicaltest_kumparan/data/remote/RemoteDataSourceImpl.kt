package com.example.thecnicaltest_kumparan.data.remote

import com.example.thecnicaltest_kumparan.data.remote.api.ApiService
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource{
    override fun getAllPost(): List<PostResponsesItem> {
        return apiService.getPosts()
    }

    override fun getAllUser(): List<UserResponsesItem> {
        return apiService.getUsers()
    }

}