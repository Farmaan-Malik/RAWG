package com.example.rawg.data.remote.responses.stores

data class StoreResult(
    val domain: String,
    val games: List<Game>,
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val name: String,
    val slug: String
)