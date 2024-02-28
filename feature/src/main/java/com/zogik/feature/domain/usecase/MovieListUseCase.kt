package com.zogik.feature.domain.usecase

import androidx.paging.PagingData
import com.zogik.model.movielist.MovieListItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:11
 **/
interface MovieListUseCase {
    fun getMovieList(genre: String): Flow<PagingData<MovieListItem>>
}
