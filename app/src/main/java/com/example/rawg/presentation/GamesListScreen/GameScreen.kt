package com.example.rawg.presentation.GamesListScreen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rawg.presentation.GamesListScreen.components.GameCard
import com.example.rawg.presentation.common.Loading
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
     val isLoading by remember { ViewModel.isLoading }
     val listState = rememberLazyListState()


     Scaffold(topBar = { MyAppBar() }, modifier = Modifier.fillMaxSize())
     { paddingValues ->
          when {
               isLoading ->
                     Toast.makeText(LocalContext.current,"Loading...", Toast.LENGTH_LONG).show()

               !isLoading ->
//          if (!isLoading) {
                    Column {

                         LazyColumn(
                              state = listState,
                              modifier = Modifier
                                   .padding(top = paddingValues.calculateTopPadding())
                                   .fillMaxSize()
                                   .background(color = Color.White),
                              content = {
                                   items(GameList) { game ->

                                        GameCard(
                                             name = game.name,
                                             rating = game.rating,
                                             released = game.released,
                                             background_image = game.background_image,
                                        ) {
                                             Log.e("LMAO1", game.name)
                                             navController.navigate("GameDetailScreen/${game.id}")
                                        }
                                        val threshold = 1
                                        if (game == GameList.getOrNull(GameList.size - threshold)) {
                                             ViewModel.loadNextPage()
                                        }

                                   }


                              })
                         Spacer(modifier = Modifier.height(10.dp))
                    }


//          }
//               else ->
//
//                    Loading()


//               Box(modifier = Modifier.fillMaxSize()) {
//                    LoadingScreen(
//                         isLoading = isLoading, modifier = Modifier
//                              .align(
//                                   Alignment.Center
//                              )
//                              .size(200.dp)
//                    )
//               }
          }
     }
}



