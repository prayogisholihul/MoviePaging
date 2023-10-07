package com.zogik.network

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Loading<out T>(val loadingState: Boolean) : Result<T>()
    data class Error(val message: String, val code: Int) : Result<Nothing>()
}
