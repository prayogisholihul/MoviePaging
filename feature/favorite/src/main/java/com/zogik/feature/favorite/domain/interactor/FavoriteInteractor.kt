package com.zogik.feature.favorite.domain.interactor

import com.zogik.feature.favorite.domain.repository.FavoriteRepo
import com.zogik.feature.favorite.domain.usecase.FavoriteUseCase
import com.zogik.model.favorite.MovieFavorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:26
 **/
class FavoriteInteractor @Inject constructor(private val repo: FavoriteRepo) : FavoriteUseCase {
    override suspend fun getFavorite(): Flow<List<MovieFavorite>> = repo.getFavorite()
}
