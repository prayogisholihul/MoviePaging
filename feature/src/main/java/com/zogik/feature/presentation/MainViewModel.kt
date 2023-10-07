package com.zogik.feature.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zogik.entity.MovieFavorite
import com.zogik.feature.domain.UseCase
import com.zogik.network.Result
import com.zogik.response.MovieDetail
import com.zogik.response.NowPlayingItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    init {
        useCase.setFavorite(MovieFavorite(968051, "The Nun II"))
    }

    fun getNowPlaying(): Flow<PagingData<NowPlayingItem>> =
        useCase.getNowPlaying().cachedIn(viewModelScope)

    var query = mutableStateOf("")
        private set

    fun setQuery(query: String) {
        this.query.value = query
    }

    fun searchMovie() = useCase.searchMovie(query.value).cachedIn(viewModelScope)

    private val _getDetail: MutableStateFlow<Result<MovieDetail>> =
        MutableStateFlow(Result.Loading(true))
    val getDetail = _getDetail.asStateFlow()
    fun getDetail(id: String) = viewModelScope.launch {
        useCase.movieDetail(id).collectLatest {
            delay(500)
            _getDetail.value = it
        }
    }

    fun getFavorite() = useCase.getFavorite()
}
