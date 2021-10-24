package com.example.thecnicaltest_kumparan.ui.post

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCase
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (useCase: UseCase) : ViewModel() {
    val post = useCase.getAllPost()
    val user = useCase.getAllUser()
}