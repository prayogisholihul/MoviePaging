package com.zogik.model.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieFavoriteEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
)
