package com.zogik.feature.detailmovie.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.zogik.feature.detailmovie.data.source.DetailSource
import com.zogik.feature.detailmovie.domain.repository.DetailRepository
import com.zogik.model.detail.MovieReview
import com.zogik.model.detail.MovieReviewMapper
import com.zogik.model.detail.VideoTrailer
import com.zogik.model.detail.VideoTrailerMapper
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:36
 **/
class DetailRepoImpl @Inject constructor(private val datasource: DetailSource) : DetailRepository {
    companion object {
        private const val PAGE_SIZE = 10
    }

    override suspend fun getTrailerVideo(movieId: String): Flow<Result<List<VideoTrailer>>> {
        return datasource.getTrailerVideo(movieId).map { it ->
            when (it) {
                is Result.Success -> {
                    val data = (it.data.results ?: arrayListOf()).map {
                        VideoTrailerMapper.toDomainModel(it)
                    }
                    Result.Success(data)
                }

                is Result.Error -> Result.Error(it.message, it.code)
                Result.Idle -> Result.Idle
                Result.Loading -> Result.Loading
            }
        }
    }

    override fun getMovieReview(movieId: String): Flow<PagingData<MovieReview>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                datasource.getMovieReview(movieId)
            },
        ).flow.map { data -> data.map { MovieReviewMapper.toDomainModel(it) } }
}
