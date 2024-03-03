package com.example.rawg.presentation.GamesListScreen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rawg.presentation.GamesListScreen.components.Carousel
import com.example.rawg.presentation.GamesListScreen.components.GameCard
import com.example.rawg.presentation.common.DotsPulsing
import com.example.rawg.presentation.common.FloatingBar
import com.example.rawg.presentation.common.LoadingMain
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

    Scaffold(topBar = { MyAppBar(navController, "G▲meZ●ne ", null) }, modifier = Modifier.fillMaxSize(),
        bottomBar = {
            FloatingBar(
                navController = navController, null
            )
        }

    )
    { paddingValues ->
        when {
            isLoading ->
                LoadingMain("Fetching Game List..", 15f, 0f, 60f)

            !isLoading ->
                Column(
                    modifier = Modifier
                        .padding(top = paddingValues.calculateTopPadding())
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF7360DF),
                                    Color(0xFF160735),
                                    Color(0xFFC499F3)
                                )
                            )
                        )
                ) {
                    if (listState.firstVisibleItemIndex == 0) {
                        Carousel(viewModel = ViewModel, navHostController = navController)
                    }
                    LazyColumn(
                        state = listState,
                        modifier = Modifier
//                            .padding(top = paddingValues.calculateTopPadding())
                            .fillMaxSize(),
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
        }
    }
}

