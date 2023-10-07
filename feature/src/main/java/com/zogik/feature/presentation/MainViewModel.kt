package com.zogik.feature.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zogik.data.NowPlayingItem
import com.zogik.feature.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    fun getNowPlaying(): Flow<PagingData<NowPlayingItem>> =
        useCase.getNowPlaying().cachedIn(viewModelScope)

    var query = mutableStateOf("")
        private set

    fun setQuery(query: String) {
        this.query.value = query
    }

    fun searchMovie() = useCase.searchMovie(query.value).cachedIn(viewModelScope)
}
