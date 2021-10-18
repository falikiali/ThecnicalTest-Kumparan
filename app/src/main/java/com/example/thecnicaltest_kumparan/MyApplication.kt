package com.example.thecnicaltest_kumparan

import android.app.Application
import com.example.thecnicaltest_kumparan.di.networkModule
import com.example.thecnicaltest_kumparan.di.repositoryModule
import com.example.thecnicaltest_kumparan.di.useCaseModule
import com.example.thecnicaltest_kumparan.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}