package com.zogik.feature.home.data.source

import androidx.paging.PagingSource
import com.zogik.model.genre.GenreResponse
import com.zogik.model.movielist.MovieListItemResponse
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 11:59
 **/
interface MovieListSource {
    fun getMovieList(genre: String): PagingSource<Int, MovieListItemResponse>
    suspend fun getGenreList(): Flow<Result<GenreResponse>>
}
