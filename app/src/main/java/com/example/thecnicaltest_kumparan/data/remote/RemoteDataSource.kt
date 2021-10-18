package com.example.thecnicaltest_kumparan.data.remote

import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem

interface RemoteDataSource {
    fun getAllPost(): List<PostResponsesItem>
    fun getAllUser(): List<UserResponsesItem>

}