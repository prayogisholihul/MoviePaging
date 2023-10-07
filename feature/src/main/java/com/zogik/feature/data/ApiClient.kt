package com.zogik.feature.data

import com.zogik.data.NowPlaying
import com.zogik.data.SearchMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page: Int): NowPlaying

    @GET("search/movie")
    suspend fun searchMovie(@Query("query") search: String, @Query("page") page: Int): SearchMovie
}
