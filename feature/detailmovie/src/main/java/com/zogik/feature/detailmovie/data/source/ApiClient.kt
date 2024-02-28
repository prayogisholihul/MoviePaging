package com.zogik.feature.detailmovie.data.source

import com.zogik.model.detail.MovieReviewResponse
import com.zogik.model.detail.VideoTrailerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:37
 **/
interface ApiClient {
    @GET("movie/{movie_id}/videos")
    suspend fun getVideoTrailer(@Path("movie_id") movieId: String): Response<VideoTrailerResponse>

    @GET("movie/{movie_id}/reviews")
    suspend fun getReviews(
        @Path("movie_id") movieId: String,
        @Query("page") page: Int,
    ): MovieReviewResponse
}
