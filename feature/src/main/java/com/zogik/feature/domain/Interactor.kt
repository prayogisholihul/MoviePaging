package com.zogik.feature.domain

import androidx.paging.PagingData
import com.zogik.data.NowPlayingItem
import com.zogik.data.SearchItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repo: Repository) : UseCase {
    override fun getNowPlaying(): Flow<PagingData<NowPlayingItem>> = repo.getNowPlaying()
    override fun searchMovie(query: String): Flow<PagingData<SearchItem>> = repo.searchMovie(query)
}