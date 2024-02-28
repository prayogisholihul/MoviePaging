package com.zogik.model.detail

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:42
 **/
object VideoTrailerMapper {
    fun toDomainModel(response: VideoTrailerItemResponse?): VideoTrailer {
        return VideoTrailer(
            site = response?.site,
            size = response?.size,
            iso31661 = response?.iso31661,
            name = response?.name,
            official = response?.official,
            id = response?.id,
            type = response?.type,
            publishedAt = response?.publishedAt,
            iso6391 = response?.iso6391,
            key = response?.key,
        )
    }
}
