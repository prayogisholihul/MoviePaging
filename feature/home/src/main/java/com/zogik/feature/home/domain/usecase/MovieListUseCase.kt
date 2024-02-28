package com.zogik.feature.home.domain.usecase

import androidx.paging.PagingData
import com.zogik.model.genre.Genre
import com.zogik.model.movielist.MovieListItem
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:11
 **/
interface MovieListUseCase {
    fun getMovieList(genre: String): Flow<PagingData<MovieListItem>>
    suspend fun getGenreList(): Flow<Result<List<Genre>>>
}
