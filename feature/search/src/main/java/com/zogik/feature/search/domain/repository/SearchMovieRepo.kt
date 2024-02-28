package com.zogik.feature.search.domain.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.zogik.model.movielist.MovieListItem
import com.zogik.model.movielist.MovieListItemResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:46
 **/
interface SearchMovieRepo {
    fun getSearchList(search: String): Flow<PagingData<MovieListItem>>
}