package com.zogik.feature.detailmovie.di

import com.zogik.feature.detailmovie.domain.interactor.DetailInteractor
import com.zogik.feature.detailmovie.domain.usecase.DetailUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:27
 **/

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideDomain(interactor: DetailInteractor): DetailUseCase
}
