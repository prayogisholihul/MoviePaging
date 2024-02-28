package com.zogik.feature.detailmovie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.feature.detailmovie.domain.usecase.DetailUseCase
import com.zogik.model.detail.VideoTrailer
import com.zogik.network.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:57
 **/
@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: DetailUseCase) : ViewModel() {
    private val _getDetail: MutableStateFlow<Result<VideoTrailer>> =
        MutableStateFlow(Result.Loading)
    val getDetail = _getDetail.asStateFlow()

    fun getDetail(id: String) = viewModelScope.launch {
        useCase.getTrailerVideo(id).catch {
            _getDetail.emit(Result.Error(it.message.orEmpty(), 0))
        }.collectLatest {
            _getDetail.value = it
        }
    }

    fun getMovieReview(movieId: String) = useCase.getMovieReview(movieId)
}
