package com.zogik.movie.navigation.home

import android.content.Context
import android.content.Intent
import com.zogik.feature.favorite.presentation.FavoriteActivity
import com.zogik.feature.home.presentation.HomeAction
import com.zogik.feature.search.presentation.SearchActivity
import javax.inject.Inject

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 16:55
 **/

class HomeNavigationImpl @Inject constructor() : HomeAction {
    override fun navigateToSearch(context: Context) {
        val intent = Intent(context, SearchActivity::class.java)
        context.startActivity(intent)
    }

    override fun navigateToFavorite(context: Context) {
        val intent = Intent(context, FavoriteActivity::class.java)
        context.startActivity(intent)
    }
}
