package com.example.thecnicaltest_kumparan.data.remote

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.data.remote.network.ApiResponse
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem

interface RemoteDataSource {
    fun getAllPost(): LiveData<ApiResponse<List<PostResponsesItem>>>
    fun getAllUser(): LiveData<ApiResponse<List<UserResponsesItem>>>

}