package com.example.rawg.data.remote.responses.creators.creatorDetails

data class CreatorDetail(
    val description: String,
    val games_count: Int,
    val id: Int,
    val image: String,
    val image_background: String,
    val name: String,
    val platforms: Platforms,
    val positions: List<Position>,
    val rating: String,
    val rating_top: Int,
    val ratings: List<Rating>,
    val reviews_count: Int,
    val slug: String,
    val timeline: List<Timeline>,
    val updated: String
)