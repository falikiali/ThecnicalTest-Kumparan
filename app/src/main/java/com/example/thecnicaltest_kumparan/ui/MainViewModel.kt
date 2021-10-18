package com.example.thecnicaltest_kumparan.ui

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseImpl

class MainViewModel(useCaseImpl: UseCaseImpl) : ViewModel() {
    val post = useCaseImpl.getAllPost()
    val user = useCaseImpl.getAllUser()
}