package com.zogik.feature.data

import com.zogik.response.MovieDetail
import com.zogik.response.NowPlaying
import com.zogik.response.SearchMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page: Int): NowPlaying

    @GET("search/movie")
    suspend fun searchMovie(@Query("query") search: String, @Query("page") page: Int): SearchMovie

    @GET("movie/{movie_id}")
    suspend fun movieDetail(@Path("movie_id") id: String): Response<MovieDetail>
}
