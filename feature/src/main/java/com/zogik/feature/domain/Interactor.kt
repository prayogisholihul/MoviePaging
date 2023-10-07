package com.zogik.feature.domain

import androidx.paging.PagingData
import com.zogik.entity.MovieFavorite
import com.zogik.network.Result
import com.zogik.response.MovieDetail
import com.zogik.response.NowPlayingItem
import com.zogik.response.SearchItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repo: Repository) : UseCase {
    override fun getNowPlaying(): Flow<PagingData<NowPlayingItem>> = repo.getNowPlaying()
    override fun searchMovie(query: String): Flow<PagingData<SearchItem>> = repo.searchMovie(query)
    override suspend fun movieDetail(id: String): Flow<Result<MovieDetail>> = repo.movieDetail(id)
    override suspend fun getFavorite(): Flow<List<MovieFavorite>> = repo.getFavorite()
    override fun setFavorite(movieFavorite: MovieFavorite) = repo.setFavorite(movieFavorite)
    override fun getFavoriteById(id: Int): MovieFavorite = repo.getFavoriteById(id)
    override fun deleteFavorite(movieFavorite: MovieFavorite) = repo.deleteFavorite(movieFavorite)
}
