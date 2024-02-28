package com.zogik.feature.home.domain.interactor

import androidx.paging.PagingData
import com.zogik.feature.home.domain.repository.MovieListRepo
import com.zogik.feature.home.domain.usecase.MovieListUseCase
import com.zogik.model.movielist.MovieListItem
import kotlinx.coroutines.flow.Flow
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
}
