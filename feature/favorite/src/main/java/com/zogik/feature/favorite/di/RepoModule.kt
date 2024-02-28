package com.zogik.feature.favorite.di

import com.zogik.feature.favorite.data.FavoriteRepoImpl
import com.zogik.feature.favorite.domain.repository.FavoriteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:36
 **/
@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideRepo(repoImpl: FavoriteRepoImpl): FavoriteRepo
}
