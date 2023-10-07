package com.zogik.feature.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zogik.data.MovieDetail
import com.zogik.data.NowPlayingItem
import com.zogik.data.SearchItem
import com.zogik.feature.domain.Repository
import com.zogik.network.BaseCall
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: ApiClient) : Repository, BaseCall() {
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

    override fun searchMovie(query: String): Flow<PagingData<SearchItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                SearchPaging(api, query)
            },
        ).flow
    }

    override suspend fun movieDetail(id: String): Flow<Result<MovieDetail>> {
        return response {
            api.movieDetail(id)
        }
    }

    companion object {
        private const val PAGE_SIZE = 10
    }
}
