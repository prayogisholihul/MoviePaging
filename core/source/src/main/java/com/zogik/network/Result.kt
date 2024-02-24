package com.zogik.network

sealed class Result<out T> {
    object Idle : Result<Nothing>()
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String, val code: Int) : Result<Nothing>()
}
