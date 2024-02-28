package com.zogik.model.genre

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 14:44
 **/
object GenreMapper {
    fun toDomain(genreResponse: GenresItemResponse?) = Genre(
        genreResponse?.name.orEmpty(),
        genreResponse?.id ?: 0,
    )
}
