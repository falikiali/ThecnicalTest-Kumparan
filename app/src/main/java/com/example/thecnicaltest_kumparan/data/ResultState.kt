package com.example.thecnicaltest_kumparan.data

sealed class ResultState<out R> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val errorMessage: String) : ResultState<Nothing>()
    object Empty : ResultState<Nothing>()
}
