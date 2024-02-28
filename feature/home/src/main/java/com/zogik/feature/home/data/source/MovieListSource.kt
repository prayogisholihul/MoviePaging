package com.zogik.feature.home.data.source

import androidx.paging.PagingSource
import com.zogik.model.movielist.MovieListItemResponse

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 11:59
 **/
interface MovieListSource {
    fun getMovieList(genre: String): PagingSource<Int, MovieListItemResponse>
}