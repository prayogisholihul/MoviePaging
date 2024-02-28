package com.zogik.model.detail

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 17:40
 **/
data class VideoTrailer(
    val site: String?,
    val size: Int?,
    val iso31661: String?,
    val name: String?,
    val official: Boolean?,
    val id: String?,
    val type: String?,
    val publishedAt: String?,
    val iso6391: String?,
    val key: String?,
) {
    val getTypeTrailer: TYPE = when (type) {
        TYPE.Trailer.value -> TYPE.Trailer
        TYPE.Teaser.value -> TYPE.Teaser
        TYPE.Featurette.value -> TYPE.Featurette
        TYPE.BTS.value -> TYPE.BTS
        else -> TYPE.UNKNOWN
    }
}

enum class TYPE(val value: String) {
    Trailer("Trailer"),
    Teaser("Teaser"),
    Featurette("Featurette"),
    BTS("Behind the Scenes"),
    UNKNOWN(""),
}
