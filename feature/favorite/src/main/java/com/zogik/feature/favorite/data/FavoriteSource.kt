package com.zogik.feature.favorite.data

import com.zogik.model.favorite.MovieFavoriteEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:01
 **/
interface FavoriteSource {
    suspend fun getFavorite(): Flow<List<MovieFavoriteEntity>>
}
