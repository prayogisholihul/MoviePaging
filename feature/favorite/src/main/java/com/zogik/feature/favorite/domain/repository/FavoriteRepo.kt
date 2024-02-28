package com.zogik.feature.favorite.domain.repository

import com.zogik.model.favorite.MovieFavorite
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:10
 **/
interface FavoriteRepo {
    suspend fun getFavorite(): Flow<List<MovieFavorite>>
}
