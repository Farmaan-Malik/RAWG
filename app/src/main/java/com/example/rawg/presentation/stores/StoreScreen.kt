package com.example.rawg.presentation.stores

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.swipeable
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.rawg.data.remote.responses.stores.Game
import com.example.rawg.presentation.common.FloatingBar
import com.example.rawg.presentation.common.LoadingMain
import com.example.rawg.presentation.common.MyAppBar
import com.example.rawg.presentation.creatorScreen.component.CreatorCard
import com.example.rawg.presentation.stores.components.StoreCard
import com.example.rawg.presentation.stores.components.StoresGameList
import org.koin.androidx.compose.koinViewModel

@Composable
fun StoreScreen(
    viewModel: StoresViewModel = koinViewModel(),
    navHostController: NavHostController
) {

    val StoreList by remember { viewModel.state }
    val isLoading by remember { viewModel.isLoading }
    var goToGames by remember {
        mutableStateOf(false)
    }
    var storeGames by remember {
        mutableStateOf<List<Game>>(listOf())
    }
    Scaffold(topBar = { MyAppBar(navHostController, "Stores", Color(0xFF174B88)) },
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            FloatingBar(
                navController = navHostController, Color(0xFF174B88)
            )
        }

    )
    { paddingValues ->
        when {
            isLoading -> {
                LoadingMain("Fetching Stores..", 15f, 0f, 60f)
            }

            !isLoading -> {
                if (goToGames) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .padding(top = paddingValues.calculateTopPadding())
                    ) {
                        StoresGameList(games = storeGames)
                    }

                } else {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .padding(top = paddingValues.calculateTopPadding())
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFBBE1FA),
                                        Color(0xFF3F72AF),
                                        Color(0xFF3282B8)
                                    )
                                )
                            ), columns = GridCells.Fixed(2)
                    ) {
                        items(StoreList) { Store ->
                            StoreCard(
                                games_count = Store.games_count,
                                name = Store.name,
                            ) {
                                storeGames = Store.games
                                goToGames = true

                            }
                        }

                    }
                }
            }
        }
    }
}