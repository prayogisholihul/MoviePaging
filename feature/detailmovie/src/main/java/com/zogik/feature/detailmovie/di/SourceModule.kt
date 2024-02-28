package com.zogik.feature.detailmovie.di

import com.zogik.feature.detailmovie.data.source.DetailSource
import com.zogik.feature.detailmovie.data.source.DetailSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:27
 **/
@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    abstract fun provideSource(source: DetailSourceImpl): DetailSource
}
