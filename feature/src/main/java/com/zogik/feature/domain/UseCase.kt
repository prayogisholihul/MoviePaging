package com.zogik.feature.domain

import androidx.paging.PagingData
import com.zogik.data.NowPlayingItem
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getNowPlaying(): Flow<PagingData<NowPlayingItem>>
}