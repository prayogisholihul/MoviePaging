package com.zogik.model.genre

import com.google.gson.annotations.SerializedName

data class GenreResponse(

    @field:SerializedName("genres")
    val genres: List<GenresItemResponse?>? = null,
)

data class GenresItemResponse(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,
)
