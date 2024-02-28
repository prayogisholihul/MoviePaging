package com.zogik.model.detail

import com.google.gson.annotations.SerializedName

data class MovieReviewResponse(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieReviewItemResponse> = arrayListOf(),

    @field:SerializedName("total_results")
    val totalResults: Int? = null,
)

data class AuthorDetailsResponse(

    @field:SerializedName("avatar_path")
    val avatarPath: Any? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("rating")
    val rating: Double? = null,

    @field:SerializedName("username")
    val username: String? = null,
)

data class MovieReviewItemResponse(

    @field:SerializedName("author_details")
    val authorDetails: AuthorDetailsResponse? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("content")
    val content: String? = null,

    @field:SerializedName("url")
    val url: String? = null,
)