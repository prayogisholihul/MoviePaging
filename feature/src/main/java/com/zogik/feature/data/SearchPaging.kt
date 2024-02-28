package com.zogik.feature.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zogik.feature.data.source.ApiClient
import com.zogik.model.SearchItem

class SearchPaging(private val api: ApiClient, private val query: String) :
    PagingSource<Int, SearchItem>() {
    override fun getRefreshKey(state: PagingState<Int, SearchItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchItem> {
        return try {
            val page = params.key ?: 1
            val response = api.searchMovie(query, page)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            Log.d("Search", e.message.orEmpty())
            LoadResult.Error(e)
        }
    }
}
