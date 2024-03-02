package com.example.rawg.data.remote.responses.creators

data class CreatorResult(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Creators>
)