package com.zogik.feature.home.di

import com.zogik.feature.home.domain.interactor.MovieListInteractor
import com.zogik.feature.home.domain.usecase.MovieListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:02
 **/

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideDomain(interactor: MovieListInteractor): MovieListUseCase
}
