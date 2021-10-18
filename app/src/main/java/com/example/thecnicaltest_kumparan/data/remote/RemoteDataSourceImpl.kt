package com.example.thecnicaltest_kumparan.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.thecnicaltest_kumparan.data.remote.api.ApiService
import com.example.thecnicaltest_kumparan.data.remote.network.ApiResponse
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource{
    override fun getAllPost(): LiveData<ApiResponse<List<PostResponsesItem>>> {
        val result = MutableLiveData<ApiResponse<List<PostResponsesItem>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getPosts()
                result.postValue(ApiResponse.Success(response))
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ApiResponse.Error(ex.message.toString()))
            }
        }
        return result
    }

    override fun getAllUser(): LiveData<ApiResponse<List<UserResponsesItem>>> {
        val result = MutableLiveData<ApiResponse<List<UserResponsesItem>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getUsers()
                result.postValue(ApiResponse.Success(response))
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ApiResponse.Error(ex.message.toString()))
            }
        }
        return result
    }

}