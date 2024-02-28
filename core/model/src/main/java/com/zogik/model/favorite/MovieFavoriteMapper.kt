package com.zogik.model.favorite

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 13:18
 **/
object MovieFavoriteMapper {
    fun toDomain(entity: MovieFavoriteEntity): MovieFavorite = MovieFavorite(
        entity.id,
        entity.title,
    )
}
