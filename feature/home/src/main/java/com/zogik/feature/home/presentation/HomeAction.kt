package com.zogik.feature.home.presentation

import android.content.Context

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 16:54
 **/
interface HomeAction {
    fun navigateToSearch(context: Context)
    fun navigateToFavorite(context: Context)
    fun navigateToDetail(context: Context, movieId: String, movieName: String)
}
