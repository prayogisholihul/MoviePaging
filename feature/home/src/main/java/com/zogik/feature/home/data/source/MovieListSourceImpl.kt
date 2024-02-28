package com.zogik.feature.home.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zogik.model.genre.GenreResponse
import com.zogik.model.movielist.MovieListItemResponse
import com.zogik.network.BaseCall
import com.zogik.network.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 11:59
 **/
class MovieListSourceImpl @Inject constructor(private val remote: ApiClient) : MovieListSource,
    BaseCall() {
    override fun getMovieList(genre: String): PagingSource<Int, MovieListItemResponse> {
        return MovieListPaging(genre)
    }

    override suspend fun getGenreList(): Flow<Result<GenreResponse>> {
        return response {
            remote.getGenre()
        }
    }

    inner class MovieListPaging(private val genre: String) :
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
