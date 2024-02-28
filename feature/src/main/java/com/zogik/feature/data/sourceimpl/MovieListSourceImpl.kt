package com.zogik.feature.data.sourceimpl

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zogik.feature.data.source.ApiClient
import com.zogik.feature.data.source.MovieListSource
import com.zogik.network.BaseCall
import com.zogik.model.movielist.MovieListItemResponse
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:07
 **/
class MovieListSourceImpl @Inject constructor(private val remote: ApiClient) : MovieListSource,
    BaseCall() {
    override fun getMovieList(genre: String): PagingSource<Int, MovieListItemResponse> {
        return NowPlayingPaging(genre)
    }

    inner class NowPlayingPaging(private val genre: String) :
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
                val response = remote.getMovieList(page, genre)

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
