package com.zogik.feature.search.di

import com.zogik.feature.search.data.source.SearchMovieSource
import com.zogik.feature.search.data.source.SearchMovieSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:02
 **/
@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    abstract fun provideSource(searchMovieSource: SearchMovieSourceImpl): SearchMovieSource
}
