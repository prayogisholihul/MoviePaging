package com.zogik.feature.favorite.di

import com.zogik.feature.favorite.data.FavoriteSource
import com.zogik.feature.favorite.data.FavoriteSourceImpl
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
abstract class SourceModule {

    @Binds
    abstract fun provideSource(sourceImpl: FavoriteSourceImpl): FavoriteSource
}
