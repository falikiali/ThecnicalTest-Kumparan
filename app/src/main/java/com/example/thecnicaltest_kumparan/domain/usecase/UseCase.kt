package com.example.thecnicaltest_kumparan.domain.usecase

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.domain.model.*
import com.example.thecnicaltest_kumparan.utils.ResultState

interface UseCase {
    fun getAllPost(): LiveData<ResultState<List<Post>>>
    fun getAllUser(): LiveData<ResultState<List<User>>>
    fun getUser(userId: Int): LiveData<ResultState<User>>
    fun getComment(postId: Int): LiveData<ResultState<List<Comment>>>
    fun getAlbum(userId: Int): LiveData<ResultState<List<Album>>>
    fun getPhoto(): LiveData<ResultState<List<Photo>>>
}