package com.example.rawg.data.remote.responses.creators

data class Creators(
    val games: List<Game>,
    val games_count: Int,
    val id: Int,
    val image: String,
    val image_background: String,
    val name: String,
    val positions: List<Position>,
    val slug: String
)