package com.example.rawg.presentation.GamesListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rawg.presentation.GamesListScreen.components.GameCard
import com.example.rawg.presentation.GamesListScreen.components.LoadingScreen
import com.example.rawg.presentation.common.MyAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameScreen(
     ViewModel: GamesListViewModel = koinViewModel()
) {
     val GameList by remember { ViewModel.state }
     val isLoading by remember { ViewModel.isLoading}

     Scaffold (topBar = { MyAppBar()}){

          paddingValues ->
          if (!isLoading) {

               LazyColumn(
                    modifier = Modifier
                         .padding(top = paddingValues.calculateTopPadding())
                         .fillMaxSize()
                         .background(Color(0xFF2E154F))
               ) {
                    items(GameList) { game ->
                         GameCard(
                              name = game.name,
                              id = game.id,
                              rating = game.rating,
                              released = game.released,
                              background_image = game.background_image,
                              dominant_color = game.dominant_color
                         )
                    }
               }
          }
          else
               Box(modifier = Modifier.fillMaxSize()) {
                    LoadingScreen(
                         isLoading = isLoading, modifier = Modifier
                              .align(
                                   Alignment.Center
                              )
                              .size(200.dp)
                    )
               }
     }
}



