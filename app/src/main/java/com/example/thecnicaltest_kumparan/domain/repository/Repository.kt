package com.example.thecnicaltest_kumparan.domain.repository

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.domain.model.Comment
import com.example.thecnicaltest_kumparan.utils.ResultState
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User

interface Repository {
    fun getAllPost(): LiveData<ResultState<List<Post>>>
    fun getAllUser(): LiveData<ResultState<List<User>>>
    fun getComment(postId: Int): LiveData<ResultState<List<Comment>>>
}