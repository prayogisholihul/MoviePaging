package com.zogik.model.movielist

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 2:14
 **/
data class MovieList(
    val dates: Dates?,
    val page: Int?,
    val totalPages: Int?,
    val results: List<MovieListItem>,
    val totalResults: Int?,
)

data class Dates(
    val maximum: String?,
    val minimum: String?,
)

data class MovieListItem(
    val overview: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val video: Boolean?,
    val title: String?,
    val genreIds: List<Int?>?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val popularity: Any?,
    val voteAverage: Double?,
    val id: Int?,
    val adult: Boolean?,
    val voteCount: Int?,
)
