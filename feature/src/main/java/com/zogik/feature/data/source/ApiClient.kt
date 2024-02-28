package com.zogik.feature.data.source

import com.zogik.model.MovieDetail
import com.zogik.model.movielist.MovieListResponse
import com.zogik.model.SearchMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("discover/movie")
    suspend fun getMovieList(
        @Query("page") page: Int,
        @Query("with_genres") genre: String,
    ): MovieListResponse

    @GET("search/movie")
    suspend fun searchMovie(@Query("query") search: String, @Query("page") page: Int): SearchMovie

    @GET("movie/{movie_id}")
    suspend fun movieDetail(@Path("movie_id") id: String): Response<MovieDetail>
}
