package com.zogik.feature.di

import com.zogik.feature.domain.interactor.MovieListInteractor
import com.zogik.feature.domain.usecase.MovieListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun movieListUseCase(movieListInteractor: MovieListInteractor): MovieListUseCase
}
