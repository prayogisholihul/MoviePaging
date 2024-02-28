package com.zogik.model.detail

/**
 * Created by : Prayogi Sholihul
 * Mailto : prayogisholihul@gmail.com
 * Created at : Wednesday 28/02/2024: 19:04
 **/
object MovieReviewMapper {
    fun toDomainModel(movieReviewItemResponse: MovieReviewItemResponse): MovieReview {
        return MovieReview(
            authorDetails = authortoDomainModel(movieReviewItemResponse),
            updatedAt = movieReviewItemResponse.updatedAt,
            author = movieReviewItemResponse.author,
            createdAt = movieReviewItemResponse.createdAt,
            id = movieReviewItemResponse.id,
            content = movieReviewItemResponse.content,
            url = movieReviewItemResponse.url,
        )
    }

    private fun authortoDomainModel(movieReviewItemResponse: MovieReviewItemResponse): AuthorDetails {
        movieReviewItemResponse.authorDetails.apply {
            return AuthorDetails(
                avatarPath = this?.avatarPath,
                name = this?.name,
                rating = this?.rating,
                username = this?.username,
            )
        }
    }
}
