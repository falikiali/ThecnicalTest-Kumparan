package com.example.thecnicaltest_kumparan.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSource
import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSourceImpl
import com.example.thecnicaltest_kumparan.domain.model.*
import com.example.thecnicaltest_kumparan.domain.repository.Repository
import com.example.thecnicaltest_kumparan.utils.DataMapper
import com.example.thecnicaltest_kumparan.utils.ResultState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor (private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getAllPost(): LiveData<ResultState<List<Post>>> {
        val result = MutableLiveData<ResultState<List<Post>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getAllPost()
                if (response.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    val dataMapped = DataMapper.mapPostResponseToEntities(response)
                    result.postValue(ResultState.Success(dataMapped))
                }
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
                if (response.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    val dataMapped = DataMapper.mapUsersResponseToEntities(response)
                    result.postValue(ResultState.Success(dataMapped))
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

    override fun getUser(userId: Int): LiveData<ResultState<User>> {
        val result = MutableLiveData<ResultState<User>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getUser(userId)
                val dataMapped = DataMapper.mapUserResponseToEntities(response)
                result.postValue(ResultState.Success(dataMapped))
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

    override fun getComment(postId: Int): LiveData<ResultState<List<Comment>>> {
        val result = MutableLiveData<ResultState<List<Comment>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getComment(postId)
                if (response.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    val dataMapped = DataMapper.mapCommentResponseToEntities(response)
                    result.postValue(ResultState.Success(dataMapped))
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

    override fun getAlbum(userId: Int): LiveData<ResultState<List<Album>>> {
        val result = MutableLiveData<ResultState<List<Album>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getAlbum(userId)
                if (response.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    val dataMapped = DataMapper.mapAlbumResponseToEntities(response)
                    result.postValue(ResultState.Success(dataMapped))
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

    override fun getPhoto(): LiveData<ResultState<List<Photo>>> {
        val result = MutableLiveData<ResultState<List<Photo>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getPhoto()
                if (response.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    val dataMapped = DataMapper.mapPhotoResponseToEntities(response)
                    result.postValue(ResultState.Success(dataMapped))
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }
        return result
    }

}