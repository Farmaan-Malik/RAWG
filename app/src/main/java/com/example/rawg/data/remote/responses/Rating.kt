package com.example.rawg.data.remote.responses

data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)