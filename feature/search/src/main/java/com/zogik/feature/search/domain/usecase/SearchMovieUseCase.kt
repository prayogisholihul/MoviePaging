package com.zogik.feature.search.domain.usecase

import androidx.paging.PagingData
import com.zogik.model.movielist.MovieListItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:49
 **/
interface SearchMovieUseCase {
    fun getSearchList(search: String): Flow<PagingData<MovieListItem>>
}