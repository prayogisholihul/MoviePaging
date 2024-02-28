package com.zogik.model.movielist

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 2:12
 **/
object MovieListMapper {
    fun mapMovieListResponseToDomain(movieListResponse: MovieListResponse): MovieList {
        val datesDomain = movieListResponse.dates?.let { Dates(it.maximum, it.minimum) }
        val movieItemsDomain =
            movieListResponse.results.map { mapMovieListItemResponseToDomain(it) }

        return MovieList(
            dates = datesDomain,
            page = movieListResponse.page,
            totalPages = movieListResponse.totalPages,
            results = movieItemsDomain,
            totalResults = movieListResponse.totalResults,
        )
    }

    fun mapMovieListItemResponseToDomain(movieListItemResponse: MovieListItemResponse): MovieListItem {
        return MovieListItem(
            overview = movieListItemResponse.overview,
            originalLanguage = movieListItemResponse.originalLanguage,
            originalTitle = movieListItemResponse.originalTitle,
            video = movieListItemResponse.video,
            title = movieListItemResponse.title,
            genreIds = movieListItemResponse.genreIds,
            posterPath = movieListItemResponse.posterPath,
            backdropPath = movieListItemResponse.backdropPath,
            releaseDate = movieListItemResponse.releaseDate,
            popularity = movieListItemResponse.popularity,
            voteAverage = movieListItemResponse.voteAverage,
            id = movieListItemResponse.id,
            adult = movieListItemResponse.adult,
            voteCount = movieListItemResponse.voteCount,
        )
    }
}
