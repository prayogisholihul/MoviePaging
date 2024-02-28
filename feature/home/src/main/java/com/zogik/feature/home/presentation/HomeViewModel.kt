package com.zogik.feature.home.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zogik.feature.home.domain.usecase.MovieListUseCase
import com.zogik.model.MovieDetail
import com.zogik.model.favorite.MovieFavoriteEntity
import com.zogik.model.genre.Genre
import com.zogik.model.movielist.MovieListItem
import com.zogik.network.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase) :
    ViewModel() {

//    val favoriteDataPass: MutableState<MovieFavoriteEntity?> = mutableStateOf(null)
    private val _genreList: MutableStateFlow<Result<List<Genre>>> = MutableStateFlow(Result.Idle)
    val genreList = _genreList.asStateFlow()
    private val genre: MutableState<Genre?> = mutableStateOf(null)

    init {
        getGenre()
    }

    private fun getGenre() {
        viewModelScope.launch {
            movieListUseCase.getGenreList().collectLatest {
                _genreList.value = it
            }
        }
    }

    fun setGenre(genreList: List<Genre>, genre: Genre) {
        genre.isSelected = true
        genreList.filter { it.id != genre.id }.map { it.isSelected = false }
        this.genre.value = genre
    }

    fun getMovieList(): Flow<PagingData<MovieListItem>> {
        val genreId = if (genre.value?.id == 0) "" else (genre.value?.id ?: "").toString()
        return movieListUseCase.getMovieList(genreId).cachedIn(viewModelScope)
    }

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
