package com.zogik.feature.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.zogik.model.movielist.MovieListItem
import com.zogik.feature.home.data.source.MovieListSource
import com.zogik.feature.home.domain.repository.MovieListRepo
import com.zogik.model.movielist.MovieListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:28
 **/
class MovieListRepoImpl @Inject constructor(private val dataSource: MovieListSource) :
    MovieListRepo {
    companion object {
        private const val PAGE_SIZE = 10
    }

    override fun getMovieList(genre: String): Flow<PagingData<MovieListItem>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                dataSource.getMovieList(genre)
            },
        ).flow.map { data -> data.map { MovieListMapper.mapMovieListItemResponseToDomain(it) } }
}
