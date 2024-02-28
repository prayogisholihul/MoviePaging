package com.zogik.feature.domain.repository

import androidx.paging.PagingData
import com.zogik.model.SearchItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:10
 **/
interface SearchMovieRepo {
    fun searchMovie(query: String): Flow<PagingData<SearchItem>>
}