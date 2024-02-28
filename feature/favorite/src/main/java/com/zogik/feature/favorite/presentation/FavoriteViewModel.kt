package com.zogik.feature.favorite.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.feature.favorite.domain.usecase.FavoriteUseCase
import com.zogik.model.favorite.MovieFavorite
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:27
 **/
class FavoriteViewModel @Inject constructor(private val useCase: FavoriteUseCase) : ViewModel() {
    private val _listFavorite: MutableStateFlow<List<MovieFavorite>> = MutableStateFlow(listOf())
    val listFavorite = _listFavorite.asStateFlow()
    fun getFavorite() = viewModelScope.launch {
        useCase.getFavorite().collectLatest {
            _listFavorite.value = it
        }
    }
}
