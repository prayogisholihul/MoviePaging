package com.zogik.model.detail

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 19:05
 **/
data class MovieReview(
    val authorDetails: AuthorDetails?,
    val updatedAt: String?,
    val author: String?,
    val createdAt: String?,
    val id: String?,
    val content: String?,
    val url: String?
)

data class AuthorDetails(
    val avatarPath: Any?,
    val name: String?,
    val rating: Double?,
    val username: String?
)