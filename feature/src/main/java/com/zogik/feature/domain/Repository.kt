package com.zogik.feature.domain

import androidx.paging.PagingData
import com.zogik.entity.MovieFavorite
import com.zogik.network.Result
import com.zogik.response.MovieDetail
import com.zogik.response.NowPlayingItem
import com.zogik.response.SearchItem
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getNowPlaying(): Flow<PagingData<NowPlayingItem>>
    fun searchMovie(query: String): Flow<PagingData<SearchItem>>
    suspend fun movieDetail(id: String): Flow<Result<MovieDetail>>
    fun getFavorite(): List<MovieFavorite>
    fun setFavorite(movieFavorite: MovieFavorite)
}
