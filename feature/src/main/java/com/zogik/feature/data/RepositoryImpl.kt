package com.zogik.feature.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zogik.data.NowPlayingItem
import com.zogik.feature.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: ApiClient) : Repository {
    override fun getNowPlaying(): Flow<PagingData<NowPlayingItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                NowPlayingPaging(api)
            },
        ).flow
    }

    companion object {
        private const val PAGE_SIZE = 10
    }
}
