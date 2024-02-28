package com.zogik.feature.search.data.source

import com.zogik.model.SearchMovie
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 12:37
 **/
interface ApiClient {
    @GET("search/movie")
    suspend fun searchMovie(@Query("query") search: String, @Query("page") page: Int): SearchMovie
}
