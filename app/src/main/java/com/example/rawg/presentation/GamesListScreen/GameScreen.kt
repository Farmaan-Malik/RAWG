package com.example.rawg.presentation.GamesListScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rawg.presentation.GamesListScreen.components.GameCard
import com.example.rawg.presentation.common.LoadingScreen
import com.example.rawg.presentation.common.MyAppBar
import org.koin.androidx.compose.koinViewModel

@SuppressLint("InvalidColorHexValue")
@Composable
fun GameScreen(
     ViewModel: GamesListViewModel = koinViewModel(),
     navController: NavHostController
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
                         .background(color = Color.White)
               ) {
                    items(GameList) { game ->

                         GameCard(
                              name = game.name,
                              id = game.id,
                              rating = game.rating,
                              released = game.released,
                              background_image = game.background_image,
                              ){
                              Log.e("LMAO1",game.name)
                              navController.navigate("GameDetailScreen/${game.id}")
                         }
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



