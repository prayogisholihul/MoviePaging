package com.zogik.feature.favorite.domain.usecase

import com.zogik.model.favorite.MovieFavorite
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:25
 **/
interface FavoriteUseCase {
    suspend fun getFavorite(): Flow<List<MovieFavorite>>
}