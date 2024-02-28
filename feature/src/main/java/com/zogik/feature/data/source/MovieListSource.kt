package com.zogik.feature.data.source

import androidx.paging.PagingSource
import com.zogik.model.movielist.MovieListItemResponse

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:18
 **/
interface MovieListSource {
    fun getMovieList(genre: String): PagingSource<Int, MovieListItemResponse>
}
