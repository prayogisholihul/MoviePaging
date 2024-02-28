package com.zogik.feature.favorite.data

import com.zogik.feature.favorite.domain.repository.FavoriteRepo
import com.zogik.model.favorite.MovieFavorite
import com.zogik.model.favorite.MovieFavoriteMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:59
 **/
class FavoriteRepoImpl constructor(private val datasource: FavoriteSource) : FavoriteRepo {
    override suspend fun getFavorite(): Flow<List<MovieFavorite>> =
        datasource.getFavorite().map { list -> list.map { MovieFavoriteMapper.toDomain(it) } }

//    override fun setFavorite(movieFavorite: MovieFavorite) {
//        local.favoriteDao().setFavorite(movieFavorite)
//    }
//
//    override fun getFavoriteById(id: Int): MovieFavorite = local.favoriteDao().getFavoriteById(id)
//    override fun deleteFavorite(movieFavorite: MovieFavorite) =
//        local.favoriteDao().deleteFavorite(movieFavorite)
}
