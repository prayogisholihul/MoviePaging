package com.zogik.feature.home.domain.interactor

import androidx.paging.PagingData
import com.zogik.feature.home.domain.repository.MovieListRepo
import com.zogik.feature.home.domain.usecase.MovieListUseCase
import com.zogik.model.genre.Genre
import com.zogik.model.movielist.MovieListItem
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:11
 **/
class MovieListInteractor @Inject constructor(private val repo: MovieListRepo) : MovieListUseCase {
    override fun getMovieList(genre: String): Flow<PagingData<MovieListItem>> {
        return repo.getMovieList(genre)
    }

    override suspend fun getGenreList(): Flow<Result<List<Genre>>> {
        return repo.getGenreList().map { result ->
            when (result) {
                Result.Idle -> Result.Idle
                Result.Loading -> Result.Loading
                is Result.Success -> {
                    val genreList = result.data
                    val genreAll = arrayListOf<Genre>()
                    genreAll.add(Genre("All", 0, true))
                    genreAll.addAll(genreList)
                    Result.Success(genreAll)
                }

                is Result.Error -> Result.Error(result.message, result.code)
            }
        }
    }
}
