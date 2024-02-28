package com.zogik.feature.home.data.source

import com.zogik.model.genre.GenreResponse
import com.zogik.model.movielist.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 11:59
 **/
interface ApiClient {
    @GET("discover/movie")
    suspend fun getMovieList(
        @Query("page") page: Int,
        @Query("with_genres") genre: String,
    ): MovieListResponse

    @GET("genre/movie/list")
    suspend fun getGenre(): Response<GenreResponse>
}
