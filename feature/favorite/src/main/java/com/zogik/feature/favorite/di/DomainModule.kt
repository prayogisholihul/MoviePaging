package com.zogik.feature.favorite.di

import com.zogik.feature.favorite.domain.interactor.FavoriteInteractor
import com.zogik.feature.favorite.domain.usecase.FavoriteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:36
 **/

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideDomain(interactor: FavoriteInteractor): FavoriteUseCase
}
