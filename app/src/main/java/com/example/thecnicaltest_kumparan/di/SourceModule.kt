package com.example.thecnicaltest_kumparan.di

import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSource
import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {
    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}