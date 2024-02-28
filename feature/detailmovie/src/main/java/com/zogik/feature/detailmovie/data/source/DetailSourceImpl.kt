package com.zogik.feature.detailmovie.data.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zogik.model.detail.MovieReviewItemResponse
import com.zogik.model.detail.VideoTrailerResponse
import com.zogik.network.BaseCall
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:35
 **/
class DetailSourceImpl @Inject constructor(private val remote: ApiClient) : DetailSource,
    BaseCall() {
    override suspend fun getTrailerVideo(movieId: String): Flow<Result<VideoTrailerResponse>> {
        return response {
            remote.getVideoTrailer(movieId)
        }
    }

    override fun getMovieReview(movieId: String): PagingSource<Int, MovieReviewItemResponse> {
        return MovieReviewPaging(movieId)
    }

    inner class MovieReviewPaging(private val movieId: String) :
        PagingSource<Int, MovieReviewItemResponse>() {
        override fun getRefreshKey(state: PagingState<Int, MovieReviewItemResponse>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieReviewItemResponse> {
            return try {
                val page = params.key ?: 1
                val response = remote.getReviews(movieId, page)

                LoadResult.Page(
                    data = response.results,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (response.results.isEmpty()) null else page.plus(1),
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }
}
