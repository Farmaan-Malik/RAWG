package com.example.rawg.data.remote.responses

data class StoreX(
    val domain: String,
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val name: String,
    val slug: String
)