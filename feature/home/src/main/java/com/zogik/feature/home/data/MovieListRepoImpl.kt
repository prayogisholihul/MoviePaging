package com.zogik.feature.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.zogik.feature.home.data.source.MovieListSource
import com.zogik.feature.home.domain.repository.MovieListRepo
import com.zogik.model.genre.Genre
import com.zogik.model.genre.GenreMapper
import com.zogik.model.movielist.MovieListItem
import com.zogik.model.movielist.MovieListMapper
import com.zogik.network.Result
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

    override suspend fun getGenreList(): Flow<Result<List<Genre>>> {
        return dataSource.getGenreList().map { result ->
            when (result) {
                is Result.Success -> {
                    val genreList = (result.data.genres ?: arrayListOf()).map { response ->
                        GenreMapper.toDomain(response)
                    }
                    Result.Success(genreList)
                }

                is Result.Error -> Result.Error(result.message, result.code)
                is Result.Idle -> Result.Idle
                is Result.Loading -> Result.Loading
            }
        }
    }
}
