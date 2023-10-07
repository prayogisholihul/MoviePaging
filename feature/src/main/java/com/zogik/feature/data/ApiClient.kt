package com.zogik.feature.data

import com.zogik.data.NowPlaying
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page: Int): NowPlaying
}
