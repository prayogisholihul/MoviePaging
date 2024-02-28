package com.zogik.feature.search.di

import com.zogik.feature.search.domain.interactor.SearchMovieInteractor
import com.zogik.feature.search.domain.usecase.SearchMovieUseCase
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
    abstract fun provideDomain(interactor: SearchMovieInteractor): SearchMovieUseCase
}
