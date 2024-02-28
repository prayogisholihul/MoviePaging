package com.zogik.feature.search.data.source

import androidx.paging.PagingSource
import com.zogik.model.movielist.MovieListItemResponse

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:38
 **/
interface SearchMovieSource {
    fun getSearchList(search: String): PagingSource<Int, MovieListItemResponse>
}