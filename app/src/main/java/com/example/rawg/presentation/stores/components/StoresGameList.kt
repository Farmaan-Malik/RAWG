package com.example.rawg.presentation.stores.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.rawg.data.remote.responses.stores.Game
@Composable
fun StoresGameList(games: List<Game>) {

    LazyColumn() {
        items(games) { game ->
            StoreGameCard(added = game.added, name = game.name)

        }
    }
}