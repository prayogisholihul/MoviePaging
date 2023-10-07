package com.zogik.feature.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zogik.response.NowPlayingItem

class NowPlayingPaging(private val api: ApiClient) : PagingSource<Int, NowPlayingItem>() {
    override fun getRefreshKey(state: PagingState<Int, NowPlayingItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NowPlayingItem> {
        return try {
            val page = params.key ?: 1
            val response = api.getNowPlaying(page)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            Log.d("NowPLaying", e.message.orEmpty())
            LoadResult.Error(e)
        }
    }
}
