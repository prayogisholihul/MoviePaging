package com.zogik.feature.domain

import androidx.paging.PagingData
import com.zogik.data.MovieDetail
import com.zogik.data.NowPlayingItem
import com.zogik.data.SearchItem
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getNowPlaying(): Flow<PagingData<NowPlayingItem>>
    fun searchMovie(query: String): Flow<PagingData<SearchItem>>
    suspend fun movieDetail(id: String): Flow<Result<MovieDetail>>
}
