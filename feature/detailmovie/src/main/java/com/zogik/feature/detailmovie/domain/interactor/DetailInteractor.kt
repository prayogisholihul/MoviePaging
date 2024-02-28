package com.zogik.feature.detailmovie.domain.interactor

import androidx.paging.PagingData
import com.zogik.feature.detailmovie.domain.repository.DetailRepository
import com.zogik.feature.detailmovie.domain.usecase.DetailUseCase
import com.zogik.model.detail.MovieReview
import com.zogik.model.detail.TYPE
import com.zogik.model.detail.VideoTrailer
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:56
 **/
class DetailInteractor @Inject constructor(private val repo: DetailRepository) : DetailUseCase {
    override suspend fun getTrailerVideo(movieId: String): Flow<Result<VideoTrailer>> {
        return repo.getTrailerVideo(movieId).map {
            when (it) {
                Result.Loading -> Result.Loading
                Result.Idle -> Result.Idle
                is Result.Error -> Result.Error(it.message, it.code)
                is Result.Success -> {
                    val data =
                        it.data.filter { mapping -> mapping.getTypeTrailer == TYPE.Trailer }[0]
                    Result.Success(data)
                }
            }
        }
    }

    override fun getMovieReview(movieId: String): Flow<PagingData<MovieReview>> {
        return repo.getMovieReview(movieId)
    }
}
