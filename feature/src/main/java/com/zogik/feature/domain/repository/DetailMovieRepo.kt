package com.zogik.feature.domain.repository

import com.zogik.network.Result
import com.zogik.model.MovieDetail
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:14
 **/
interface DetailMovieRepo {
    suspend fun movieVideos(id: String): Flow<Result<MovieDetail>>
    suspend fun movieReviews(id: String): Flow<Result<MovieDetail>>
}
