package com.example.thecnicaltest_kumparan.domain.usecase

import androidx.lifecycle.LiveData
import com.example.thecnicaltest_kumparan.data.RepositoryImpl
import com.example.thecnicaltest_kumparan.utils.ResultState
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User

class UseCaseImpl(private val repositoryImpl: RepositoryImpl) : UseCase {
    override fun getAllPost(): LiveData<ResultState<List<Post>>> {
        return repositoryImpl.getAllPost()
    }

    override fun getAllUser(): LiveData<ResultState<List<User>>> {
        return repositoryImpl.getAllUser()
    }

}