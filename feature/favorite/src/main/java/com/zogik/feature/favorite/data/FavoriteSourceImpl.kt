package com.zogik.feature.favorite.data

import com.zogik.model.favorite.MovieFavoriteEntity
import com.zogik.network.room.DatabaseApp
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:02
 **/
class FavoriteSourceImpl @Inject constructor(private val local: DatabaseApp) : FavoriteSource {
    override suspend fun getFavorite(): Flow<List<MovieFavoriteEntity>> =
        local.favoriteDao().getFavorite()
}
