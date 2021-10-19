package com.example.thecnicaltest_kumparan.data.remote

import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem

interface RemoteDataSource {
    suspend fun getAllPost(): List<PostResponsesItem>
    suspend fun getAllUser(): List<UserResponsesItem>

}