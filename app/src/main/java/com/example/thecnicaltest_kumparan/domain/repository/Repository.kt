package com.example.thecnicaltest_kumparan.domain.repository

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.data.ResultState
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User

interface Repository {
    fun getAllPost(): LiveData<ResultState<List<Post>>>
    fun getAllUser(): LiveData<ResultState<List<User>>>
}