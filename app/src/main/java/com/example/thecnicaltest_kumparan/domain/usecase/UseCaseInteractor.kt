package com.example.thecnicaltest_kumparan.domain.usecase

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.data.RepositoryImpl
import com.example.thecnicaltest_kumparan.domain.model.*
import com.example.thecnicaltest_kumparan.domain.repository.Repository
import com.example.thecnicaltest_kumparan.utils.ResultState
import javax.inject.Inject

class UseCaseInteractor @Inject constructor (private val repository: Repository) : UseCase {
    override fun getAllPost(): LiveData<ResultState<List<Post>>> = repository.getAllPost()

    override fun getAllUser(): LiveData<ResultState<List<User>>> = repository.getAllUser()

    override fun getUser(userId: Int): LiveData<ResultState<User>> = repository.getUser(userId)

    override fun getComment(postId: Int): LiveData<ResultState<List<Comment>>> = repository.getComment(postId)

    override fun getAlbum(userId: Int): LiveData<ResultState<List<Album>>> = repository.getAlbum(userId)

    override fun getPhoto(): LiveData<ResultState<List<Photo>>> = repository.getPhoto()
}