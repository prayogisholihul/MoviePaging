package com.zogik.feature.home.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zogik.feature.home.data.Genre
import com.zogik.feature.home.data.dummyGenres
import com.zogik.feature.home.domain.usecase.MovieListUseCase
import com.zogik.model.MovieDetail
import com.zogik.model.favorite.MovieFavoriteEntity
import com.zogik.model.movielist.MovieListItem
import com.zogik.network.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase) :
    ViewModel() {

    val favoriteDataPass: MutableState<MovieFavoriteEntity?> = mutableStateOf(null)
    private var genre = mutableStateOf(dummyGenres[0])
    fun setGenre(genre: Genre) {
        genre.selected = true
        dummyGenres.filter { it.id != genre.id }.map { it.selected = false }
        this.genre.value = genre
    }

    fun getMovieList(): Flow<PagingData<MovieListItem>> =
        movieListUseCase.getMovieList((genre.value.id ?: "").toString()).cachedIn(viewModelScope)

    private val _getDetail: MutableStateFlow<Result<MovieDetail>> =
        MutableStateFlow(Result.Loading)
    val getDetail = _getDetail.asStateFlow()
    fun getDetail(id: String) = viewModelScope.launch {
//        useCase.movieDetail(id).collectLatest {
//            delay(500)
//            _getDetail.value = it
//        }
    }

    fun getFavoriteById(id: Int) {
//        useCase.getFavoriteById(id)
    }

    fun setFavorite(movieFavorite: MovieFavoriteEntity) {
//        useCase.setFavorite(movieFavorite)
    }

    fun deleteFavorite(movieFavorite: MovieFavoriteEntity) {
//        useCase.deleteFavorite(movieFavorite)
    }
}
