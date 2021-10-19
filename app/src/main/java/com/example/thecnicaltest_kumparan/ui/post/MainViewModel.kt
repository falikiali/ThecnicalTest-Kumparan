package com.example.thecnicaltest_kumparan.ui.post

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (useCaseInteractor: UseCaseInteractor) : ViewModel() {
    val post = useCaseInteractor.getAllPost()
    val user = useCaseInteractor.getAllUser()
}