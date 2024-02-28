package com.zogik.feature.domain.repository

import androidx.paging.PagingData
import com.zogik.model.movielist.MovieListItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:08
 **/
interface MovieListRepo {
    fun getMovieList(genre: String): Flow<PagingData<MovieListItem>>
}
