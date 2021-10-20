package com.example.thecnicaltest_kumparan.domain.usecase

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.data.RepositoryImpl
import com.example.thecnicaltest_kumparan.domain.model.Comment
import com.example.thecnicaltest_kumparan.utils.ResultState
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User
import javax.inject.Inject

class UseCaseInteractor @Inject constructor (private val repositoryImpl: RepositoryImpl) : UseCase {
    override fun getAllPost(): LiveData<ResultState<List<Post>>> = repositoryImpl.getAllPost()

    override fun getAllUser(): LiveData<ResultState<List<User>>> = repositoryImpl.getAllUser()

    override fun getUser(userId: Int): LiveData<ResultState<User>> = repositoryImpl.getUser(userId)

    override fun getComment(postId: Int): LiveData<ResultState<List<Comment>>> = repositoryImpl.getComment(postId)
}