package com.zogik.feature.search.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zogik.model.movielist.MovieListItemResponse
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:39
 **/
class SearchMovieSourceImpl @Inject constructor(private val remote: ApiClient) : SearchMovieSource {

    override fun getSearchList(search: String): PagingSource<Int, MovieListItemResponse> {
        return SearchPaging(search)
    }

    inner class SearchPaging(private val search: String) :
        PagingSource<Int, MovieListItemResponse>() {
        override fun getRefreshKey(state: PagingState<Int, MovieListItemResponse>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieListItemResponse> {
            return try {
                val page = params.key ?: 1
                val response = remote.searchMovie(search, page)

                LoadResult.Page(
                    data = response.results,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (response.results.isEmpty()) null else page.plus(1),
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }
}
