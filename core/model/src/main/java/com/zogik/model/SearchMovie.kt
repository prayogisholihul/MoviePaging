package com.zogik.model

import com.google.gson.annotations.SerializedName
import com.zogik.model.movielist.MovieListItemResponse

data class SearchMovie(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieListItemResponse> = arrayListOf(),

    @field:SerializedName("total_results")
    val totalResults: Int? = null,
)