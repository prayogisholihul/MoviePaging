package com.zogik.network

import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseCall {
    suspend fun <ResultType> response(api: suspend () -> Response<ResultType>): Flow<Result<ResultType>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    emit(Result.Loading(true))
                    val response: Response<ResultType> = api()
                    emit(Result.Loading(false))
                    if (response.isSuccessful) {
                        response.body()?.let {
                            emit(Result.Success(data = it))
                        } ?: emit(Result.Error(message = "Unknown error occurred", code = 0))
                    } else {
                        emit(
                            Result.Error(
                                message = parserErrorBody(response.errorBody()),
                                code = response.code(),
                            ),
                        )
                    }
                } catch (e: Exception) {
                    emit(Result.Error(message = message(e), code = code(e)))
                }
            }
        }
    }

    private fun parserErrorBody(response: ResponseBody?): String {
        return response?.let {
            val errorMessage = JsonParser().parse(it.string()).asJsonObject["message"].asString
            errorMessage.ifEmpty { "Whoops! Something went wrong" }
            errorMessage
        } ?: "Unknown error occur, please try again"
    }

    private fun message(throwable: Throwable?): String {
        return when (throwable) {
            is SocketTimeoutException -> "Whoops! connection time out, try again!"
            is IOException -> "No internet connection, try again!"
            is HttpException -> try {
                val errorJsonString = throwable.response()?.errorBody()?.string()
                val errorMessage =
                    JsonParser().parse(errorJsonString).asJsonObject["message"].asString
                errorMessage.ifEmpty { "Whoops! Something went wrong" }
            } catch (e: Exception) {
                "Unknown error occur, please try again!"
            }

            else -> "Unknown error occur, please try again!"
        }
    }

    private fun code(throwable: Throwable?): Int {
        return when (throwable) {
            is HttpException -> (throwable).code()
            else -> 0
        }
    }
}
