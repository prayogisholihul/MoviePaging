package com.zogik.feature.search.di

import com.zogik.feature.search.data.SearchRepoImpl
import com.zogik.feature.search.domain.repository.SearchMovieRepo
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
    abstract fun provideRepo(repoImpl: SearchRepoImpl): SearchMovieRepo
}
