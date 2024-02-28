package com.zogik.feature.search.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.zogik.feature.search.data.source.SearchMovieSource
import com.zogik.feature.search.domain.repository.SearchMovieRepo
import com.zogik.model.movielist.MovieListItem
import com.zogik.model.movielist.MovieListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:38
 **/
class SearchRepoImpl @Inject constructor(private val datasource: SearchMovieSource): SearchMovieRepo {
    companion object {
        private const val PAGE_SIZE = 10
    }

    override fun getSearchList(search: String): Flow<PagingData<MovieListItem>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                datasource.getSearchList(search)
            },
        ).flow.map { data -> data.map { MovieListMapper.mapMovieListItemResponseToDomain(it) } }
}