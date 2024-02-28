package com.zogik.movie

import com.zogik.feature.home.presentation.HomeAction
import com.zogik.movie.navigation.home.HomeNavigationImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 16:56
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun provideHomeNav(navigationImpl: HomeNavigationImpl): HomeAction
}
