package com.zogik.feature.detailmovie.data.source

import androidx.paging.PagingSource
import com.zogik.model.detail.MovieReviewItemResponse
import com.zogik.model.detail.VideoTrailerResponse
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:35
 **/
interface DetailSource {
    suspend fun getTrailerVideo(movieId: String): Flow<Result<VideoTrailerResponse>>
    fun getMovieReview(movieId: String): PagingSource<Int, MovieReviewItemResponse>
}
