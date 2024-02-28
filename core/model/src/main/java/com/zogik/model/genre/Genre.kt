package com.zogik.model.genre

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 14:44
 **/
data class Genre(
    val name: String,
    val id: Int,
    var isSelected: Boolean = false
)
