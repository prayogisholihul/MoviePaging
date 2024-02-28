package com.zogik.feature.di

import com.zogik.feature.data.repositoryimpl.MovieListRepoImpl
import com.zogik.feature.domain.repository.MovieListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun movieListRepo(movieListRepoImpl: MovieListRepoImpl): MovieListRepo
}
