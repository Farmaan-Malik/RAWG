package com.example.rawg.data.remote.responses.stores

data class StoreResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<StoreResult>
)