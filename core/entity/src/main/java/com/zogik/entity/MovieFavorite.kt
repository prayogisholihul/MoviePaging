package com.zogik.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieFavorite(
    @PrimaryKey
    val id: Int,
    val title: String,
)
