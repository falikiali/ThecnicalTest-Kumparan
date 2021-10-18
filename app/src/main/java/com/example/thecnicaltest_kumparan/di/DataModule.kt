package com.example.thecnicaltest_kumparan.di

import com.example.thecnicaltest_kumparan.data.RepositoryImpl
import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSource
import com.example.thecnicaltest_kumparan.data.remote.RemoteDataSourceImpl
import com.example.thecnicaltest_kumparan.data.remote.api.ApiService
import com.example.thecnicaltest_kumparan.domain.repository.Repository
import com.example.thecnicaltest_kumparan.domain.usecase.UseCase
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseImpl
import com.example.thecnicaltest_kumparan.ui.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<Repository> { RepositoryImpl(get()) }
}

val useCaseModule = module {
    factory<UseCase> { UseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}