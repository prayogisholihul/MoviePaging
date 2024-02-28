package com.zogik.feature.home.di

import com.zogik.feature.home.data.MovieListRepoImpl
import com.zogik.feature.home.domain.repository.MovieListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:01
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideRepo(repoImpl: MovieListRepoImpl): MovieListRepo
}
