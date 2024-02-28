package com.zogik.feature.search.domain.interactor

import androidx.paging.PagingData
import com.zogik.feature.search.domain.repository.SearchMovieRepo
import com.zogik.feature.search.domain.usecase.SearchMovieUseCase
import com.zogik.model.movielist.MovieListItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:49
 **/
class SearchMovieInteractor @Inject constructor(private val repo: SearchMovieRepo) :
    SearchMovieUseCase {
    override fun getSearchList(search: String): Flow<PagingData<MovieListItem>> =
        repo.getSearchList(search)
}
