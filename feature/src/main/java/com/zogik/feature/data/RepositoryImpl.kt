package com.zogik.feature.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zogik.entity.MovieFavorite
import com.zogik.feature.domain.Repository
import com.zogik.network.BaseCall
import com.zogik.network.Result
import com.zogik.network.room.DatabaseApp
import com.zogik.response.MovieDetail
import com.zogik.response.NowPlayingItem
import com.zogik.response.SearchItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiClient,
    private val local: DatabaseApp,
) : Repository, BaseCall() {
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

    override suspend fun getFavorite(): Flow<List<MovieFavorite>> = local.favoriteDao().getFavorite()
    override fun setFavorite(movieFavorite: MovieFavorite) {
        local.favoriteDao().setFavorite(movieFavorite)
    }

    override fun getFavoriteById(id: Int): MovieFavorite = local.favoriteDao().getFavoriteById(id)
    override fun deleteFavorite(movieFavorite: MovieFavorite) =
        local.favoriteDao().deleteFavorite(movieFavorite)

    companion object {
        private const val PAGE_SIZE = 10
    }
}
