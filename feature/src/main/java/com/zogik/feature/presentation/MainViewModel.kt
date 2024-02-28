package com.zogik.feature.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zogik.entity.MovieFavorite
import com.zogik.feature.data.Genre
import com.zogik.feature.data.dummyGenres
import com.zogik.model.movielist.MovieListItem
import com.zogik.feature.domain.usecase.MovieListUseCase
import com.zogik.network.Result
import com.zogik.model.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase) :
    ViewModel() {

    val favoriteDataPass: MutableState<MovieFavorite?> = mutableStateOf(null)
    private var genre = mutableStateOf(dummyGenres[0])
    fun setGenre(genre: Genre) {
        genre.selected = true
        dummyGenres.filter { it.id != genre.id }.map { it.selected = false }
        this.genre.value = genre
    }

    fun getMovieList(): Flow<PagingData<MovieListItem>> =
        movieListUseCase.getMovieList((genre.value.id ?: "").toString()).cachedIn(viewModelScope)

    var query = mutableStateOf("")
        private set

    fun setQuery(query: String) {
        this.query.value = query
    }

    fun searchMovie() {
//        useCase.searchMovie(query.value).cachedIn(viewModelScope)
    }

    private val _getDetail: MutableStateFlow<Result<MovieDetail>> =
        MutableStateFlow(Result.Loading)
    val getDetail = _getDetail.asStateFlow()
    fun getDetail(id: String) = viewModelScope.launch {
//        useCase.movieDetail(id).collectLatest {
//            delay(500)
//            _getDetail.value = it
//        }
    }

    private val _listFavorite: MutableStateFlow<List<MovieFavorite>> = MutableStateFlow(listOf())
    val listFavorite = _listFavorite.asStateFlow()
    fun getFavorite() = viewModelScope.launch {
//        useCase.getFavorite().collectLatest {
//            _listFavorite.value = it
//        }
    }

    fun getFavoriteById(id: Int) {
//        useCase.getFavoriteById(id)
    }

    fun setFavorite(movieFavorite: MovieFavorite) {
//        useCase.setFavorite(movieFavorite)
    }

    fun deleteFavorite(movieFavorite: MovieFavorite) {
//        useCase.deleteFavorite(movieFavorite)
    }
}
