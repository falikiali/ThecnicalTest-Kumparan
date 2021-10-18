package com.example.thecnicaltest_kumparan.domain.usecase

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.utils.ResultState
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User

interface UseCase {
    fun getAllPost(): LiveData<ResultState<List<Post>>>
    fun getAllUser(): LiveData<ResultState<List<User>>>
}