package com.zogik.feature.detailmovie.domain.usecase

import androidx.paging.PagingData
import com.zogik.model.detail.MovieReview
import com.zogik.model.detail.VideoTrailer
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:56
 **/
interface DetailUseCase {
    suspend fun getTrailerVideo(movieId: String): Flow<Result<VideoTrailer>>
    fun getMovieReview(movieId: String): Flow<PagingData<MovieReview>>
}