package com.example.thecnicaltest_kumparan.di

import com.example.thecnicaltest_kumparan.domain.usecase.UseCase
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(useCaseInteractor: UseCaseInteractor): UseCase
}