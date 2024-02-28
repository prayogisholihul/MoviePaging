package com.zogik.feature.di

import com.zogik.feature.data.source.MovieListSource
import com.zogik.feature.data.sourceimpl.MovieListSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 1:21
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    abstract fun movieListSource(movieListSourceImpl: MovieListSourceImpl): MovieListSource
}
