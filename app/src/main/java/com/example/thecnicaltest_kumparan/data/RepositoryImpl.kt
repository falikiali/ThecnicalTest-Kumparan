package com.example.thecnicaltest_kumparan.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSource
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User
import com.example.thecnicaltest_kumparan.domain.repository.Repository
import com.example.thecnicaltest_kumparan.utils.DataMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getAllPost(): LiveData<ResultState<List<Post>>> {
        val result = MutableLiveData<ResultState<List<Post>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getAllPost()
                val dataMapped = DataMapper.mapPostResponseToEntities(response)
                result.postValue(ResultState.Success(dataMapped))
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

    override fun getAllUser(): LiveData<ResultState<List<User>>> {
        val result = MutableLiveData<ResultState<List<User>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getAllUser()
                val dataMapped = DataMapper.mapUserResponseToEntities(response)
                result.postValue(ResultState.Success(dataMapped))
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

}