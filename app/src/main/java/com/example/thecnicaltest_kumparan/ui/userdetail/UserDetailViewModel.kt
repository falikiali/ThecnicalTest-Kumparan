package com.example.thecnicaltest_kumparan.ui.userdetail

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCase
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun getAlbum(userId: Int) = useCase.getAlbum(userId)

    val listPhoto = useCase.getPhoto()
}