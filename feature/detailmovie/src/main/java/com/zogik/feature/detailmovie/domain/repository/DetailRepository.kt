package com.zogik.feature.detailmovie.domain.repository

import androidx.paging.PagingData
import com.zogik.model.detail.MovieReview
import com.zogik.model.detail.VideoTrailer
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:39
 **/
interface DetailRepository {
    suspend fun getTrailerVideo(movieId: String): Flow<Result<List<VideoTrailer>>>
    fun getMovieReview(movieId: String): Flow<PagingData<MovieReview>>
}
