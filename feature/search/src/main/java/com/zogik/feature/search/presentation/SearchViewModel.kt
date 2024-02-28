package com.zogik.feature.search.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.zogik.feature.search.domain.usecase.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:54
 **/
@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: SearchMovieUseCase) : ViewModel() {
    var query = mutableStateOf("")
        private set

    fun setQuery(query: String) {
        this.query.value = query
    }

    fun searchMovie() = useCase.getSearchList(query.value).cachedIn(viewModelScope)
}
