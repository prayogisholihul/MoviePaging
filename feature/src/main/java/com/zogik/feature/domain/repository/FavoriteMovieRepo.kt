package com.zogik.feature.domain.repository

import com.zogik.entity.MovieFavorite
import kotlinx.coroutines.flow.Flow

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:10
 **/
interface FavoriteMovieRepo {
    suspend fun getFavorite(): Flow<List<MovieFavorite>>
    fun setFavorite(movieFavorite: MovieFavorite)
    fun getFavoriteById(id: Int): MovieFavorite
    fun deleteFavorite(movieFavorite: MovieFavorite)
}